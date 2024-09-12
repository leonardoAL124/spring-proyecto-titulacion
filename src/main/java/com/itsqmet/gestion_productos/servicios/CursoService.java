package com.itsqmet.gestion_productos.servicios;

import com.itsqmet.gestion_productos.modelos.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    Curso saveCurso(Curso curso);

    List<Curso> getCursos();

    Optional<Curso> getCursoById(int idCurso);

    void deleteCurso(int idCurso);
    
}
