package com.example.clinica.controller;

import com.example.clinica.model.Odontologo;
import com.example.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OdontologoController {

    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/odontologo")
    public Odontologo crear(@RequestBody Odontologo odontologo) {
        return this.odontologoService.crear(odontologo);
    }

    @GetMapping("/odontologo")
    public List<Odontologo> obtenerTodosOdontologos(){
        return odontologoService.obtenerTodosOdontologos();

    }

    @DeleteMapping("/odontologo/{matricula}")
    public Odontologo eliminarOdontologo(@PathVariable("matricula") Integer matricula){
        return odontologoService.eliminarOdontologo(matricula);
    }


    //crear endpoint para obtener todos los odontologo
    //crear endpoint para eliminar odontologo por matricula
}
