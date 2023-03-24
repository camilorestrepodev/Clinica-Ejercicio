package com.example.clinica.service;

import com.example.clinica.model.Odontologo;
import com.example.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo crear(Odontologo odontologo) {
        this.odontologoRepository.save(odontologo);
        return odontologo;
    }

    public List<Odontologo> obtenerTodosOdontologos(){
        Iterable<Odontologo> iterableOdontologo = odontologoRepository.findAll();
        List<Odontologo> odontologos  = new ArrayList<>();
        iterableOdontologo.forEach(odontologos::add);
        return odontologos;
    }

    public Odontologo eliminarOdontologo(Integer matricula){
        Optional<Odontologo> optOdontologo = odontologoRepository.findById(matricula);
        if(optOdontologo.isPresent()){
            this.odontologoRepository.deleteById(matricula);
        }else {
            throw new RuntimeException("El odontologo que desea eliminar no se encuentra");
        }
        return optOdontologo.get();
    }

}
