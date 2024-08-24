package com.itsqmet.gestion_productos.modelos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAula;
    private int numeroAula;
    private int capacidad;
    
    // Relación y enlace con Curso
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso")
    private Curso curso;

}
