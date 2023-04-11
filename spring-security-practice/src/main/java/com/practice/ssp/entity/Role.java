package com.practice.ssp.entity;

import java.util.HashSet;
import java.util.Set;

import com.practice.ssp.constants.DbConstants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "roles", schema = DbConstants.SCHEMA_PUBLIC)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @SequenceGenerator(
        name = DbConstants.SEQ_ROLES_ID,
        sequenceName = DbConstants.SEQ_ROLES_ID,
        allocationSize = DbConstants.ALLOCATION_SIZE
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = DbConstants.SEQ_ROLES_ID
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
