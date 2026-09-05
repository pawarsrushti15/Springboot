package com.jpaproject.ems.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

@entity
public class Employee {
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
git add
}
