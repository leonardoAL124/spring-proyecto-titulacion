package com.itsqmet.gestion_productos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itsqmet.gestion_productos.modelos.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{

}
