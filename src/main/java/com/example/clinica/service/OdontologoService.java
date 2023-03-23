package com.example.clinica.service;

import com.example.clinica.model.Odontologo;
import com.example.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OdontologoService {

    private OdontologoRepository  odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo crear (Odontologo odontologo){
        this.odontologoRepository.save(odontologo);
        return odontologo;
    }
}
