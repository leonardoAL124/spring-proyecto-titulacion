package com.itsqmet.gestion_productos.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.itsqmet.gestion_productos.modelos.Aula;
import com.itsqmet.gestion_productos.servicios.impl.AulaServiceImpl;

import org.springframework.web.bind.annotation.*;

// Declaramos que la clase es un controlador
@Controller
@RequestMapping("/aula")
public class AulaController {

    // Instanciamos el servicio implementado
    @Autowired
    AulaServiceImpl aulaServiceImpl;

    // Métodos de envío y almacenje entre front y back
    // Guardar
    @PostMapping("path")
    public ResponseEntity<Aula> saveAula(@RequestBody Aula aula) {
        try {
            Aula savedAula = aulaServiceImpl.saveAula(aula);
            return new ResponseEntity<>(savedAula, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    // Actualizar
    @PutMapping
    public ResponseEntity<Aula> updateAula(@RequestBody Aula aula) {
        try {
            Aula updatedAula = aulaServiceImpl.updateAula(aula);
            return new ResponseEntity<>(updatedAula, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Listar todos
    @GetMapping
    public ResponseEntity<List<Aula>> getAllAulas() {
        return new ResponseEntity<>(aulaServiceImpl.getAulas(), HttpStatus.OK);
    }

    // Tomar un objeto por el id
    @GetMapping("/{idAula}")
    public ResponseEntity<Aula> getAulaById(@PathVariable int idAula) {
        Optional<Aula> aula = aulaServiceImpl.getAulaById(idAula);
        if (aula.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aula.get(), HttpStatus.OK);
    }

    // Eliminar
    @DeleteMapping("/{idAula}")
    public ResponseEntity<Void> deleteAula(@PathVariable int idAula) {
        Optional<Aula> aula = aulaServiceImpl.getAulaById(idAula);
        if (aula.isPresent()) {
            aulaServiceImpl.deleteAula(aula.get().getIdAula());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
