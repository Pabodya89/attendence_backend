package com.example.attendence.service;

import com.example.attendence.dto.request.VoiceRequestDto;
import com.example.attendence.dto.response.VoiceResponseDto;

public interface AttendanceService {
    VoiceResponseDto markByVoice(VoiceRequestDto dto);
}

