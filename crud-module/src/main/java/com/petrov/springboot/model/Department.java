package com.petrov.springboot.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
    @Column(name = "department")
    private String department;
}
