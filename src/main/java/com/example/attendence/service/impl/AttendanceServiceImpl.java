package com.example.attendence.service.impl;

import com.example.attendence.dto.request.VoiceRequestDto;
import com.example.attendence.dto.response.VoiceResponseDto;
import com.example.attendence.entity.Student;
import com.example.attendence.entity.enums.AttendanceStatus;
import com.example.attendence.repository.AttendanceRepository;
import com.example.attendence.repository.StudentRepository;
import com.example.attendence.service.AttendanceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private AttendanceRepository attendanceRepo;

    @Override
    public VoiceResponseDto markByVoice(VoiceRequestDto dto) {
        String input = dto.getTranscript().toLowerCase().trim();

        Optional<Student> studentOpt = studentRepo.findByCodeIgnoreCase(input)
                .or(() -> studentRepo.findByNameIgnoreCase(input));

        if (studentOpt.isEmpty()) {
            throw new EntityNotFoundException("Student not found");
        }

        Student student = studentOpt.get();
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalTime end = LocalTime.of(8, 30);

        if (attendanceRepo.existsByStudentIdAndDate(student.getStudentId(), today)) {
            return new VoiceResponseDto("Already marked today", "DUPLICATE");
        }

        AttendanceStatus status = now.isBefore(end) ? AttendanceStatus.PRESENT : AttendanceStatus.ABSENT;

        com.example.attendence.entity.Attendance att = new com.example.attendence.entity.Attendance();
        att.setStudent(student);
        att.setDate(today);
        att.setTimeMarked(now);
        att.setStatus(status);
        att.setMethod("voice");

        attendanceRepo.save(att);
        return new VoiceResponseDto("Attendance marked as " + status, status.name());
    }
}

