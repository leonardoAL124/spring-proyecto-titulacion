package com.itsqmet.gestion_productos.servicios;

import com.itsqmet.gestion_productos.modelos.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {

    Matricula saveMatricula(Matricula matricula);

    Matricula updateMatricula(Matricula matricula);

    List<Matricula> getMatriculas();

    Optional<Matricula> getMatriculaById(int idMatricula);

    void deleteMatricula(int idMatricula);
    
}
