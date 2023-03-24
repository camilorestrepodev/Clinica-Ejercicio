package com.example.clinica.controller;

import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.repository.PacienteRepository;
import com.example.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PacienteController {

    private PacienteRepository pacienteRepository;
    @Autowired
    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService servicioPaciente) {
        this.pacienteService = servicioPaciente;
    }

    @PostMapping("/paciente")
    public Paciente crear(@RequestBody Paciente paciente) {
        return this.pacienteService.crear(paciente);
    }

    @GetMapping("/paciente")
    public List<Paciente> obtenerPacientes(){
        return pacienteService.obtenerTodosPacientes();

    }

    @DeleteMapping("/paciente/{dni}")
    public Paciente eliminarPaciente(@PathVariable("dni") Integer dni){
        return pacienteService.eliminarPaciente(dni);
    }

}
