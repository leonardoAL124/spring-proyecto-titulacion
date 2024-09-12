package com.itsqmet.gestion_productos.modelos;

import jakarta.persistence.*;
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
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso")
    private Curso curso;

}
