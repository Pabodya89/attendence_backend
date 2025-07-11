package com.example.attendence.util.mappers;

import com.example.attendence.dto.request.StudentRequestDto;
import com.example.attendence.dto.response.StudentResponseDto;
import com.example.attendence.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentResponseDto toDto(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setCode(student.getCode());
        dto.setName(student.getName());
        dto.setCode(student.getCode());
        dto.setAddress(student.getAddress());
        dto.setBirthday(student.getBirthday());
        dto.setContactNumber(student.getContactNumber());
        return dto;
    }

    public Student toEntity(StudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setCode(dto.getCode());
        student.setBirthday(dto.getBirthday());
        student.setAddress(dto.getAddress());
        student.setContactNumber(dto.getContactNumber());
        return student;
    }
}

