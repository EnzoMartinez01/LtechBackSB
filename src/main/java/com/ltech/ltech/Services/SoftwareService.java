package com.ltech.ltech.Services;

import org.springframework.stereotype.Service;

import com.ltech.ltech.Dto.ResponseDto;
import com.ltech.ltech.Dto.SoftwareDto;

@Service
public interface SoftwareService {
    public ResponseDto getAllSoftware();
    public ResponseDto getSoftware(Integer idSoftware);
    public ResponseDto createSoftware(SoftwareDto software);
    public ResponseDto updateSoftware(SoftwareDto software);
    public ResponseDto disabledSoftware(Integer idSoftware);
}
