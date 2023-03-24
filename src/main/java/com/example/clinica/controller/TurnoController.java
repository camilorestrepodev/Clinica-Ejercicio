package com.example.clinica.controller;

import com.example.clinica.model.Turno;
import com.example.clinica.service.OdontologoService;
import com.example.clinica.service.PacienteService;
import com.example.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TurnoController {

    private TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/asignar")
    public Turno generar(@RequestBody Turno turno){
        Integer dni = turno.getPaciente().getDni();
        Integer matricula = turno.getOdontologo().getMatricula();
        String fechaTurno = turno.getFecha();
        return this.turnoService.generar(dni,matricula,fechaTurno);
    }


    //crear controlador de asignar el turno.
}
