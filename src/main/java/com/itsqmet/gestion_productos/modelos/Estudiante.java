package com.itsqmet.gestion_productos.modelos;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Estudiante implements Serializable {

    @Id
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String cedula;

}
