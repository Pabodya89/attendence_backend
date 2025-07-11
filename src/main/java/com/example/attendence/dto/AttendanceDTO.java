package com.example.attendence.dto;

import com.example.attendence.entity.enums.AttendanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceDTO {

    private int attendanceId;
    private int studentId;
    private String studentName;       // helpful for frontend display
    private LocalDate date;
    private LocalTime timeMarked;
    private AttendanceStatus status;
    private String method;            // e.g., "voice"
    private Object data;              // optional for custom payload
}

