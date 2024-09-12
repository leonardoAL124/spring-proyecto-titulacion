package com.itsqmet.gestion_productos.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.gestion_productos.modelos.Estudiante;
import com.itsqmet.gestion_productos.repositorios.EstudianteRepository;
import com.itsqmet.gestion_productos.servicios.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    EstudianteRepository estudianteRepository;

    @Override
    public Estudiante saveEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiante> getEstudianteById(int idEstudiante) {
        return estudianteRepository.findById(idEstudiante);
    }

    @Override
    public void deleteEstudiante(int idEstudiante) {
        estudianteRepository.deleteById(idEstudiante);
    }
    
}
