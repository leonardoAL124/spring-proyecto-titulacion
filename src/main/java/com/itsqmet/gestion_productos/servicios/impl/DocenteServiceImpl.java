package com.itsqmet.gestion_productos.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.gestion_productos.modelos.Docente;
import com.itsqmet.gestion_productos.repositorios.DocenteRepository;
import com.itsqmet.gestion_productos.servicios.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService{

    @Autowired
    DocenteRepository docenteRepository;

    @Override
    public Docente saveDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public Docente updateDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public List<Docente> getDocentes() {
        return docenteRepository.findAll();
    }

    @Override
    public Optional<Docente> getDocenteById(int idDocente) {
        return docenteRepository.findById(idDocente);
    }

    @Override
    public void deleteDocente(int idDocente) {
        docenteRepository.deleteById(idDocente);
    }
    
}
