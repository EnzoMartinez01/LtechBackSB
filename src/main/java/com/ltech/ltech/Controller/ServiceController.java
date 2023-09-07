package com.ltech.ltech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltech.ltech.Dto.ResponseDto;
import com.ltech.ltech.Dto.ServiceDto;
import com.ltech.ltech.Services.ServicesService;

@RestController
@RequestMapping("/api/v1/ltech/services")
public class ServiceController {

    @Autowired
    private ServicesService servServ;

    //Metodo para listar Servicios
    @GetMapping("/getservices")
    public ResponseEntity<ResponseDto> readAllServices(){
        return ResponseEntity.status(HttpStatus.OK).body(servServ.getAllServices());
    }

    //Metodo para listar Servicio ID
    @GetMapping("/getservice/{idService}")
    public ResponseEntity<ResponseDto> readService(@PathVariable("idService") Integer idService){
        return ResponseEntity.status(HttpStatus.OK).body(servServ.getService(idService));
    }

    //Metodo para crear Servicio
    @PostMapping("/createservice")
    public ResponseEntity<ResponseDto> createService(@RequestBody ServiceDto service){
        return ResponseEntity.status(HttpStatus.CREATED).body(servServ.createService(service));
    }

    //Metodo para actualizar Servicio
    @PutMapping("/updateservice")
    public ResponseEntity<ResponseDto> updateService(@RequestBody ServiceDto service){
        return ResponseEntity.status(HttpStatus.CREATED).body(servServ.updateService(service));
    }

    //Metodo para desactivar un Servicio
    @DeleteMapping("/disabledservice/{idService}")
    public ResponseEntity<ResponseDto> disabledService(@PathVariable("idService") Integer idService){
        return ResponseEntity.status(HttpStatus.OK).body(servServ.disabledService(idService));
    }
}
