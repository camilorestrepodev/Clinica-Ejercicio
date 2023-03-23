package com.example.clinica.controller;

import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.service.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class PacienteController {

    private ServicioPaciente servicioPaciente;

    @Autowired
    public PacienteController(ServicioPaciente servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }

    @PostMapping("/paciente")
    public Paciente crear(@RequestBody Paciente paciente) {
        return this.servicioPaciente.crear(paciente);
    }


    //crear endpoint para obtener todos los paciente
    //crear endpoint para eliminar paciente por dni
}
