package com.practice.ssp.entity;

import java.util.HashSet;
import java.util.Set;

import com.practice.ssp.constants.DbConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = DbConstants.TBL_AUTHORITIES, schema = DbConstants.SCHEMA_PUBLIC)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
