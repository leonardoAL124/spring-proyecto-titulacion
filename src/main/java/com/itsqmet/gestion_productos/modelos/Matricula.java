package com.itsqmet.gestion_productos.modelos;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Matricula implements Serializable {

    @Id
    private int idMatricula;
    private Date fechaMatriculacion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCurso")
    private Curso curso;

}
