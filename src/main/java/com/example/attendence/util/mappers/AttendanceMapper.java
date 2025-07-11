package com.example.attendence.util.mappers;

import com.example.attendence.dto.response.AttendanceResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AttendanceMapper {

    public AttendanceResponseDto toDto(com.example.attendence.entity.Attendance attendance) {
        AttendanceResponseDto dto = new AttendanceResponseDto();
        dto.setId(attendance.getAttendanceId());
        dto.setStudentName(attendance.getStudent().getName());
        dto.setDate(attendance.getDate());
        dto.setTimeMarked(attendance.getTimeMarked());
        dto.setStatus(attendance.getStatus().name());
        dto.setMethod(attendance.getMethod());
        return dto;
    }
}
