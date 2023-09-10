package com.ltech.ltech.Services.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltech.ltech.Dto.ResponseDto;
import com.ltech.ltech.Dto.SoftwareDto;
import com.ltech.ltech.Entity.SoftwareEntity;
import com.ltech.ltech.Repository.SoftwareRepository;
import com.ltech.ltech.Services.SoftwareService;
import com.ltech.ltech.Util.Constante;
import com.ltech.ltech.Util.Util;


@Service
public class SofwareServiceImp implements SoftwareService{
    @Autowired
    private SoftwareRepository softRep;
    
    @Override
    public ResponseDto getAllSoftware(){
        try{
            List<SoftwareEntity> software = softRep.findAll();
            if(software.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<SoftwareDto> softwareDto = new ArrayList<SoftwareDto>();
            for (SoftwareEntity softwareEntity : software){
                softwareDto.add(SoftwareDto.builder()
                                .idSoftware(softwareEntity.getIdSoftware())
                                .nameService(softwareEntity.getNameService())
                                .descriptionService(softwareEntity.getDescriptionService())
                                .enabled(softwareEntity.getEnabled())
                                .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, softwareDto);
        } catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getSoftware(Integer idSoftware){
        try{
            SoftwareEntity softwareEntity = softRep.findById(idSoftware).orElse(null);
            if(null == softwareEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            SoftwareDto softwareDto = SoftwareDto.builder()
                                    .idSoftware(softwareEntity.getIdSoftware())
                                    .nameService(softwareEntity.getNameService())
                                    .descriptionService(softwareEntity.getDescriptionService())
                                    .enabled(softwareEntity.getEnabled())
                                    .build();
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, softwareDto);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto createSoftware(SoftwareDto software){
        try{
            SoftwareEntity softwareEntity = SoftwareEntity.builder()
                                    .nameService(software.getNameService())
                                    .descriptionService(software.getDescriptionService())
                                    .enabled(true)
                                    .build();
            softRep.save(softwareEntity);
            software.setIdSoftware(softwareEntity.getIdSoftware());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, software);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateSoftware(SoftwareDto software){
        try{
            SoftwareEntity softwareEntity = softRep.findById(software.getIdSoftware()).orElse(null);
            if(null == softwareEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            softwareEntity.setNameService(software.getNameService());
            softwareEntity.setDescriptionService(software.getDescriptionService());
            softwareEntity.setEnabled(software.getEnabled());
            softRep.save(softwareEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, software);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto disabledSoftware(Integer idSoftware){
        try{
            SoftwareEntity softwareEntity = softRep.findById(idSoftware).orElse(null);
            softwareEntity.setEnabled(false);
            softRep.save(softwareEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch(Exception e){
            return Util.getResponse(false, Constante.NO_RECORDS_FOUND, null);
        }
    }
}
