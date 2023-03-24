package com.example.clinica.service;

import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private List<Paciente> pacientes;
    public PacienteService(){
        this.pacientes = new ArrayList<>();
    }
    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente crear(Paciente paciente){
        if(paciente.getDni() < 0 || paciente.getNombre() == null){
            throw new RuntimeException("Paciente no puede tener nombre nulo o dni negativo");
        }
        this.pacienteRepository.save(paciente);
        return paciente;
    }

    public List<Paciente> obtenerTodosPacientes(){
        Iterable<Paciente> iterableOdontologo = pacienteRepository.findAll();
        List<Paciente> pacientes1  = new ArrayList<>();
        iterableOdontologo.forEach(pacientes1::add);
        return pacientes1;
    }

    public Paciente eliminarPaciente(Integer dni){
        Optional<Paciente> optPaciente = pacienteRepository.findById(dni);
        if(optPaciente.isPresent()){
            this.pacienteRepository.deleteById(dni);
        }else {
            throw new RuntimeException("El odontologo que desea eliminar no se encuentra");
        }
        return optPaciente.get();
    }

}
