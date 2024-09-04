package com.employee_management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String department;
    private String gender;
    private String city;
    private String pinCode;
}
