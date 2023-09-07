package com.ltech.ltech.Services.Implement;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ltech.ltech.Dto.ResponseDto;
import com.ltech.ltech.Dto.ServiceDto;
import com.ltech.ltech.Entity.ServiceEntity;
import com.ltech.ltech.Repository.ServiceRepository;
import com.ltech.ltech.Services.ServicesService;
import com.ltech.ltech.Util.Constante;
import com.ltech.ltech.Util.Util;

@Service
public class ServicesServiceImp implements ServicesService {
    @Autowired
    private ServiceRepository servRep;

    @Override
    public ResponseDto getAllServices(){
        try{
            List<ServiceEntity> services = servRep.findAll();
            if(services.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<ServiceDto> serviceDto = new ArrayList<ServiceDto>();
            for (ServiceEntity serviceEntity : services){
                serviceDto.add(ServiceDto.builder()
                                .idService(serviceEntity.getIdService())
                                .nameService(serviceEntity.getNameService())
                                .descriptionService(serviceEntity.getDescriptionService())
                                .enabled(serviceEntity.getEnabled())
                                .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, serviceDto);
        } catch (Exception e) {
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getService(Integer idService){
        try{
            ServiceEntity serviceEntity = servRep.findById(idService).orElse(null);
            if(null == serviceEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            ServiceDto serviceDto = ServiceDto.builder()
                                    .idService(serviceEntity.getIdService())
                                    .nameService(serviceEntity.getNameService())
                                    .descriptionService(serviceEntity.getDescriptionService())
                                    .enabled(serviceEntity.getEnabled())
                                    .build();
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, serviceDto);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto createService(ServiceDto service){
        try{
            ServiceEntity serviceEntity = ServiceEntity.builder()
                                    .nameService(service.getNameService())
                                    .descriptionService(service.getDescriptionService())
                                    .enabled(true)
                                    .build();
            servRep.save(serviceEntity);
            service.setIdService(serviceEntity.getIdService());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, service);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateService(ServiceDto service){
        try{
            ServiceEntity serviceEntity = servRep.findById(service.getIdService()).orElse(null);
            if(null == serviceEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            serviceEntity.setNameService(service.getNameService());
            serviceEntity.setDescriptionService(service.getDescriptionService());
            serviceEntity.setEnabled(service.getEnabled());
            servRep.save(serviceEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, service);
        } catch(Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto disabledService(Integer idService){
        try{
            ServiceEntity serviceEntity = servRep.findById(idService).orElse(null);
            serviceEntity.setEnabled(false);
            servRep.save(serviceEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch(Exception e){
            return Util.getResponse(false, Constante.NO_RECORDS_FOUND, null);
        }
    }
}
