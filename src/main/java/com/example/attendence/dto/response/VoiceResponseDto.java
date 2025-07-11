package com.example.attendence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoiceResponseDto {
    private String message;
    private String status; // Present, Absent, etc.
}

