package com.example.attendence.repository;

import com.example.attendence.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByStudentIdAndDate(Long studentId, LocalDate date);
}
