package com.ltech.ltech.Services;

import org.springframework.stereotype.Service;
import com.ltech.ltech.Dto.ResponseDto;
import com.ltech.ltech.Dto.ServiceDto;

@Service
public interface ServicesService {
    public ResponseDto getAllServices();
    public ResponseDto getService(Integer idService);
    public ResponseDto createService(ServiceDto service);
    public ResponseDto updateService(ServiceDto service);
    public ResponseDto disabledService(Integer idService);
}
