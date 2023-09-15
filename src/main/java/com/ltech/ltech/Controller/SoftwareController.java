package com.ltech.ltech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ltech.ltech.Dto.ResponseDto;
import com.ltech.ltech.Dto.SoftwareDto;
import com.ltech.ltech.Services.SoftwareService;

@RestController
@RequestMapping("/api/v1/ltech/software")
@CrossOrigin("*")
public class SoftwareController {
    @Autowired
    private SoftwareService softServ;

    //Metodo para listar Softwares
    @GetMapping("/getsoftware")
    public ResponseEntity<ResponseDto> readAllServices(){
        return ResponseEntity.status(HttpStatus.OK).body(softServ.getAllSoftware());
    }

    //Metodo para listar Software ID
    @GetMapping("/getsoftware/{idSoftware}")
    public ResponseEntity<ResponseDto> readService(@PathVariable("idSoftware") Integer idSoftware){
        return ResponseEntity.status(HttpStatus.OK).body(softServ.getSoftware(idSoftware));
    }

    //Metodo para crear Software
    @PostMapping("/createsoftware")
    public ResponseEntity<ResponseDto> createService(@RequestBody SoftwareDto software){
        return ResponseEntity.status(HttpStatus.CREATED).body(softServ.createSoftware(software));
    }

    //Metodo para actualizar Software
    @PutMapping("/updatesoftware")
    public ResponseEntity<ResponseDto> updateService(@RequestBody SoftwareDto software){
        return ResponseEntity.status(HttpStatus.CREATED).body(softServ.updateSoftware(software));
    }

    //Metodo para desactivar un Software
    @DeleteMapping("/disabledsoftware/{idSoftware}")
    public ResponseEntity<ResponseDto> disabledService(@PathVariable("idSoftware") Integer idSoftware){
        return ResponseEntity.status(HttpStatus.OK).body(softServ.disabledSoftware(idSoftware));
    }
}
