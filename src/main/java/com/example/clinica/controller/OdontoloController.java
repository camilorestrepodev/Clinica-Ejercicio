package com.example.clinica.controller;

import com.example.clinica.model.Odontologo;
import com.example.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class OdontoloController {

    private OdontologoService odontologoService;

    @Autowired
    public OdontoloController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/odontologo")
    public Odontologo crear(@RequestBody Odontologo odontologo) {
        return this.odontologoService.crear(odontologo);
    }

    //crear endpoint para obtener todos los odontologo
    //crear endpoint para eliminar odontologo por matricula
}
