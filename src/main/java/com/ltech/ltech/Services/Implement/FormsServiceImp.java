package com.ltech.ltech.Services.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltech.ltech.Dto.FormsDto;
import com.ltech.ltech.Dto.ResponseDto;
import com.ltech.ltech.Entity.FormsEntity;
import com.ltech.ltech.Repository.FormsRepository;
import com.ltech.ltech.Services.FormsService;
import com.ltech.ltech.Util.Constante;
import com.ltech.ltech.Util.Util;

@Service
public class FormsServiceImp  implements FormsService{
    @Autowired
    private FormsRepository formRep;

    @Override
    public ResponseDto getFormsAll(){
        try{
            List<FormsEntity> listFormsEntity = formRep.findAll();
            if(listFormsEntity.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<FormsDto> listFormsDto = new ArrayList<FormsDto>();
            for (FormsEntity formsEntity : listFormsEntity){
                listFormsDto.add(FormsDto.builder()
                                    .id(formsEntity.getId())
                                    .name(formsEntity.getName())
                                    .lastname(formsEntity.getLastname())
                                    .email(formsEntity.getEmail())
                                    .telephone(formsEntity.getTelephone())
                                    .message(formsEntity.getMessage())
                                    .attended(formsEntity.getAttended())
                                    .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, listFormsDto);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getForm(Integer id){
        try{
            FormsEntity formEnt = formRep.findById(id).orElse(null);
            if(null == formEnt){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            FormsDto formsDto = FormsDto.builder()
                                .id(formEnt.getId())
                                .name(formEnt.getName())
                                .lastname(formEnt.getLastname())
                                .email(formEnt.getEmail())
                                .telephone(formEnt.getTelephone())
                                .message(formEnt.getMessage())
                                .attended(formEnt.getAttended())
                                .build();
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, formsDto);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto addForm(FormsDto forms){
        try{
            FormsEntity formsEntity = FormsEntity.builder()
                                        .name(forms.getName())
                                        .lastname(forms.getLastname())
                                        .email(forms.getEmail())
                                        .telephone(forms.getTelephone())
                                        .message(forms.getMessage())
                                        .attended(false)
                                        .build();
            formRep.save(formsEntity);
            forms.setId(formsEntity.getId());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, forms);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateForm(FormsDto forms){
        try{
            FormsEntity formsEntity = formRep.findById(forms.getId()).orElse(null);
            if(null == formsEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            formsEntity.setName(forms.getName());
            formsEntity.setLastname(forms.getLastname());
            formsEntity.setEmail(forms.getEmail());
            formsEntity.setTelephone(forms.getTelephone());
            formsEntity.setMessage(forms.getMessage());
            formsEntity.setAttended(forms.getAttended());
            formRep.save(formsEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, forms);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto disableForm(Integer id){
        try{
            FormsEntity formsEntity = formRep.findById(id).orElse(null);
            formsEntity.setAttended(true);
            formRep.save(formsEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }
}
