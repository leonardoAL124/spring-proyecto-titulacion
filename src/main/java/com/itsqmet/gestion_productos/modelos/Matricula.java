package com.itsqmet.gestion_productos.modelos;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Matricula {

    @Id
    private int idMatricula;
    private Date fechaMatricula;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso")
    private Curso curso;

}
