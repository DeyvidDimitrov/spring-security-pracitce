package com.practice.ssp.entity;

import java.util.Set;

import com.practice.ssp.constants.DbConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    @Column(name = "name", nullable = false)
    private String name;
}
