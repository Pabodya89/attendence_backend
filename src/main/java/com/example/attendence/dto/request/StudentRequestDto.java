package com.example.attendence.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequestDto {
    private String name;
    private String code;
    private Date birthday;
    private String contactNumber;
    private String address;
}

