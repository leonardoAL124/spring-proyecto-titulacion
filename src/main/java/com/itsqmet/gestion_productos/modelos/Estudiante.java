package com.itsqmet.gestion_productos.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estudiante {

    @Id
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String cedula;

}
