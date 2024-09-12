package com.itsqmet.gestion_productos.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.gestion_productos.modelos.Matricula;
import com.itsqmet.gestion_productos.repositorios.MatriculaRepository;
import com.itsqmet.gestion_productos.servicios.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    @Autowired
    MatriculaRepository matriculaRepository;

    @Override
    public Matricula saveMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public List<Matricula> getMatriculas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Optional<Matricula> getMatriculaById(int idMatricula) {
        return matriculaRepository.findById(idMatricula);
    }

    @Override
    public void deleteMatricula(int idMatricula) {
        matriculaRepository.deleteById(idMatricula);
    }

}
