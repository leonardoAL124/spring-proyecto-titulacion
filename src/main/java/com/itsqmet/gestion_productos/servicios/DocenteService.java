package com.itsqmet.gestion_productos.servicios;

import com.itsqmet.gestion_productos.modelos.Docente;

import java.util.List;
import java.util.Optional;

public interface DocenteService {

    Docente saveDocente(Docente docente);

    List<Docente> getDocentes();

    Optional<Docente> getDocenteById(int idDocente);

    void deleteDocente(int idDocente);

}
