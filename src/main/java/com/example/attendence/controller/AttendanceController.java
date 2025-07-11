package com.example.demo.controller;

import com.example.attendence.dto.response.AttendanceResponseDto;
import com.example.attendence.dto.request.VoiceRequestDto;
import com.example.attendence.dto.response.VoiceResponseDto;
import com.example.attendence.service.AttendanceService;
import com.example.attendence.util.mappers.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attendance")
@CrossOrigin
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping(path = "/voice")
    public ResponseEntity<StandardResponse> markByVoice(@RequestBody VoiceRequestDto dto) {
        VoiceResponseDto result = attendanceService.markByVoice(dto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Attendance marked via voice", result),
                HttpStatus.CREATED
        );
    }

    // You can add more endpoints like manual marking, get-all, get-by-date if needed
}
