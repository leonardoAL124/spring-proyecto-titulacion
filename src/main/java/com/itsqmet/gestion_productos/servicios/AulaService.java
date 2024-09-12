package com.itsqmet.gestion_productos.servicios;

import com.itsqmet.gestion_productos.modelos.Aula;

import java.util.List;
import java.util.Optional;

// Los servicios son interfaces que permiten definir los métodos que tendran los modelos al implementarse
public interface AulaService {

    // Guardar
    Aula saveAula(Aula aula);

    // Modificar
    Aula updateAula(Aula aula);

    // Obtener lista de Aulas
    List<Aula> getAulas();

    // Obtener estudiante mediante ID
    Optional<Aula> getAulaById(int idAula);

    // Eliminar al estudiante
    void deleteAula(int idAula);

}
