package com.example.attendence.service.impl;

import com.example.attendence.dto.StudentDTO;
import com.example.attendence.dto.request.StudentRequestDto;
import com.example.attendence.dto.response.StudentResponseDto;
import com.example.attendence.entity.Student;
import com.example.attendence.repository.StudentRepository;
import com.example.attendence.service.StudentService;
import com.example.attendence.util.mappers.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentIMPL implements StudentService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public void addStudent(StudentRequestDto dto) {
        Student student = studentMapper.toEntity(dto);

        if (!studentRepository.existsById(student.getStudentId())) {
            String encryptedCode = passwordEncoder.encode(dto.getCode());
            student.setCode(encryptedCode);

            studentRepository.save(student);
        } else {
            System.out.println("Student ID already exists.");
        }
    }

    @Override
    public String updateStudent(int studentId, StudentDTO dto) {
        Optional<Student> studentOptional = studentRepository.findById((long) studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName(dto.getName());
            student.setCode(dto.getCode());
            student.setBirthday(dto.getBirthday());
            student.setContactNumber(dto.getContactNumber());
            student.setAddress(dto.getAddress());
            studentRepository.save(student);
            return "updated";
        } else {
            return "no student found at this ID";
        }
    }

    @Override
    public StudentResponseDto getStudentById(int studentId) {
        Optional<Student> studentOptional = studentRepository.findById((long) studentId);
        return studentOptional.map(studentMapper::toDto).orElse(null);
    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteStudent(int studentId) {
        if (studentRepository.existsById((long) studentId)) {
            studentRepository.deleteById((long) studentId);
            return "deleted";
        } else {
            return "no student found at this ID";
        }
    }
}
