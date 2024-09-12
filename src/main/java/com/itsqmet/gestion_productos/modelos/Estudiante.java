package com.itsqmet.gestion_productos.modelos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEstudiante;
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String cedula;

}
