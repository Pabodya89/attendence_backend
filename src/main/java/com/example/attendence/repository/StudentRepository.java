package com.example.attendence.repository;

import com.example.attendence.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByCodeIgnoreCase(String code);
    Optional<Student> findByNameIgnoreCase(String name);
}

