package com.example.attendence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", length = 45)
    private Long studentId;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "code", length = 50, nullable = false, unique = true)
    private String code;

    @Column(name = "birthday", length = 255, nullable = false )
    private Date birthday;

    @Column(name = "contactNumber" , length = 100, nullable = false)
    private String contactNumber;

    @Column(name = "address" , length = 255)
    private String address;
}


