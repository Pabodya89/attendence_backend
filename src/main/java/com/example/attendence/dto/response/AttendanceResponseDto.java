package com.example.attendence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceResponseDto {

    private int id;
    private String studentName;
    private LocalDate date;
    private LocalTime timeMarked;
    private String status;  // PRESENT / ABSENT / LATE
    private String method;  // "voice", "manual", etc.
}
