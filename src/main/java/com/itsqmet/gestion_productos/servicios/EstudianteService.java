package com.itsqmet.gestion_productos.servicios;

import com.itsqmet.gestion_productos.modelos.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    Estudiante saveEstudiante(Estudiante estudiante);

    List<Estudiante> getEstudiantes();

    Optional<Estudiante> getEstudianteById(int idEstudiante);

    void deleteEstudiante(int idEstudiante);

}
