package com.soa.student_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @Column(nullable = false, updatable = false, length = 8)
    private int cin;
    private String Name;
    private String lastName;
    private String mail;
    private int phone;
    private String establishment;
}
