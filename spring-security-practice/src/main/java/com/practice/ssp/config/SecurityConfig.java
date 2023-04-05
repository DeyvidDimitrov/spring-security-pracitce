package com.practice.ssp.config;

import static com.practice.ssp.constants.CommonPaths.PATH_DETAILS_LIGHT_PUBLIC;
import static com.practice.ssp.constants.PathConstants.PATH_ADMIN;
import static com.practice.ssp.constants.PathConstants.PATH_CURRENT;
import static com.practice.ssp.constants.PathConstants.PATH_GET_TOTAL_WEIGHT_LOST;
import static com.practice.ssp.constants.PathConstants.PATH_HOME;
import static com.practice.ssp.constants.PathConstants.PATH_LOGIN;
import static com.practice.ssp.constants.PathConstants.PATH_NOMENCLATURES;
import static com.practice.ssp.constants.PathConstants.PATH_REGISTER;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.OPTIONS;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import java.util.Arrays;

import com.practice.ssp.config.jwt.JwtAuthFilter;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    private static final String[] AUTH_WHITELIST = {
            PATH_HOME,
            PATH_GET_TOTAL_WEIGHT_LOST,
            "/actuator",
            PATH_LOGIN,
            PATH_REGISTER,
            PATH_DETAILS_LIGHT_PUBLIC + "/**",
            "/roles"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable(); // Disable CSRF (cross site request forgery)
        http.cors(); // Enable CORS

        // Set session management to stateless
        http
                .sessionManagement()
                .sessionCreationPolicy(STATELESS)
                .and();

        // Set unauthorized requests exception handler
        http = http
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                )
                .and();
        // Set permissions on endpoints
        http
                .authenticationProvider(authenticationProvider)
                // Add JWT token filter
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter .class)
                .authorizeRequests()
                // Public endpoints
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // Private endpoints
                .requestMatchers(PATH_ADMIN + "/**").authenticated()
                .requestMatchers(PATH_NOMENCLATURES + "/**").authenticated()
                .requestMatchers(PATH_CURRENT + "/**").authenticated()
                .requestMatchers("/admin").hasAuthority("ADMIN")
                .requestMatchers("/user").authenticated()
                .anyRequest()
                .authenticated()
                .and();

        return http.build();
    }

    // Used by Spring Security if CORS is enabled
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList(
                GET.name(),
                POST.name(),
                PUT.name(),
                PATCH.name(),
                DELETE.name(),
                OPTIONS.name()));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}