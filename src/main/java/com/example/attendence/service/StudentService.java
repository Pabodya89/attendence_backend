package com.example.attendence.service;

import com.example.attendence.dto.StudentDTO;
import com.example.attendence.dto.request.StudentRequestDto;
import com.example.attendence.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentService {
    String updateStudent(int id, StudentDTO dto);

    String deleteStudent(int id);

    StudentResponseDto getStudentById(int id);

    List<StudentResponseDto> getAllStudents();

    void addStudent(StudentRequestDto dto);
}
