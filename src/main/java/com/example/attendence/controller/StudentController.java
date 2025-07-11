package com.example.attendence.controller;

import com.example.attendence.dto.StudentDTO;
import com.example.attendence.dto.request.StudentRequestDto;
import com.example.attendence.dto.response.StudentResponseDto;
import com.example.attendence.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin(origins = "http://localhost:3001")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/save")
    public String saveStudent(@RequestBody StudentRequestDto studentDTO) {
       studentService.addStudent(studentDTO);
       return "saved";
    }

    @PutMapping(path = "/update")
    public String updateStudent(
            @RequestBody StudentDTO studentDTO
    ) {
        studentService.updateStudent(studentDTO.getStudentId(), studentDTO);
        return "updated";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "deleted";
    }

    @GetMapping(path = "/get/{id}")
    public StudentResponseDto getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(path = "/get-all")
    public List<StudentResponseDto> getAllStudents() {
        List<StudentResponseDto> list = studentService.getAllStudents();
        return studentService.getAllStudents();
    }
}

