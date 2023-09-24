package com.ltech.ltech.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ltech.ltech.Dto.FormsDto;
import com.ltech.ltech.Dto.ResponseDto;
import com.ltech.ltech.Services.FormsService;

@RestController
@RequestMapping("/api/v1/ltech/forms")
@CrossOrigin("*")
public class FormsController {

    @Autowired
    private FormsService formServ;

    //Metodo para listar formularios
    @GetMapping("/getforms")
    public ResponseEntity<ResponseDto> readAllForms(){
        return ResponseEntity.status(HttpStatus.OK).body(formServ.getFormsAll());
    }

    //Metodo para listar Formulario
    @GetMapping("/getform/{id}")
    public ResponseEntity<ResponseDto> readForm(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(formServ.getForm(id));
    }

    //Metodo para crear Formulario
    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public ResponseEntity<ResponseDto> createForm(@RequestBody FormsDto forms){
        return ResponseEntity.status(HttpStatus.CREATED).body(formServ.addForm(forms));
    }

    //Metodo para actualizar Formulario
    @PutMapping("/updateform")
    public ResponseEntity<ResponseDto> updateForm(@RequestBody FormsDto forms){
        return ResponseEntity.status(HttpStatus.CREATED).body(formServ.updateForm(forms));
    }

    @DeleteMapping("/disabledform/{id}")
    public ResponseEntity<ResponseDto> disabledForm(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(formServ.disableForm(id));
    }
}
