package com.itsqmet.gestion_productos.modelos;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    
    private String nombre;
    private String descripcion;
    private int creditos;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idDocente")
    private Docente docente;

}
