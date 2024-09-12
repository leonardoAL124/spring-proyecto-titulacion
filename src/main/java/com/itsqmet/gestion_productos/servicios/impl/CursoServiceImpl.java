package com.itsqmet.gestion_productos.servicios.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsqmet.gestion_productos.modelos.Curso;
import com.itsqmet.gestion_productos.repositorios.CursoRepository;
import com.itsqmet.gestion_productos.servicios.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> getCursoById(int idCurso) {
        return cursoRepository.findById(idCurso);
    }

    @Override
    public void deleteCurso(int idCurso) {
        cursoRepository.deleteById(idCurso);
    }
    
}
