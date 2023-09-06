package com.ltech.ltech.Services;

import org.springframework.stereotype.Service;

import com.ltech.ltech.Dto.FormsDto;
import com.ltech.ltech.Dto.ResponseDto;

@Service
public interface FormsService {
    public ResponseDto getFormsAll();
    public ResponseDto getForm(Integer id);
    public ResponseDto addForm(FormsDto forms);
}
