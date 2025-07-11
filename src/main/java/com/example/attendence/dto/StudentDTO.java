package com.example.attendence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {

    private int studentId;
    private String name;
    private String code;
    private Date birthday;
    private String contactNumber;
    private String address;
    private Object data;  // Optional: for extra frontend or backend use
}

