package com.itsqmet.gestion_productos.modelos;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Curso implements Serializable {

    @Id
    private int idCurso;
    private String nombre;
    private String descripcion;
    private int creditos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDocente")
    private Docente docente;

}
