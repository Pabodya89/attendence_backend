package com.example.attendence.entity;

import com.example.attendence.entity.Student;
import com.example.attendence.entity.enums.AttendanceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendance_id", length = 45)
    private int attendanceId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time_marked", nullable = false)
    private LocalTime timeMarked;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20, nullable = false)
    private AttendanceStatus status;

    @Column(name = "method", length = 20)
    private String method;


}

