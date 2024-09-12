package com.itsqmet.gestion_productos.modelos;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Docente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDocente;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String cedula;
    private String especializacion;

}
