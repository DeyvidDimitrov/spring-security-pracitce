package com.practice.ssp.entity;

import com.practice.ssp.constants.DbConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = DbConstants.TBL_USERS, schema = DbConstants.SCHEMA_PUBLIC)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @SequenceGenerator(
            name = DbConstants.SEQ_USERS_ID,
            sequenceName = DbConstants.SEQ_USERS_ID,
            allocationSize = DbConstants.ALLOCATION_SIZE
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = DbConstants.SEQ_USERS_ID
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Email
    @NotBlank(message = "Email is required.")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "Password is required.")
    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }
}