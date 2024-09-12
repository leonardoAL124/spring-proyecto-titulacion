package com.itsqmet.gestion_productos.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.gestion_productos.modelos.Matricula;
import com.itsqmet.gestion_productos.servicios.impl.MatriculaServiceImpl;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    MatriculaServiceImpl matriculaServiceImpl;

    @PostMapping("path")
    public ResponseEntity<Matricula> saveMatricula(@RequestBody Matricula matricula) {
        try {
            Matricula savedMatricula = matriculaServiceImpl.saveMatricula(matricula);
            return new ResponseEntity<>(savedMatricula, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Matricula> updateMatricula(@RequestBody Matricula matricula) {
        try {
            Matricula updatedMatricula = matriculaServiceImpl.updateMatricula(matricula);
            return new ResponseEntity<>(updatedMatricula, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getAllMatriculas() {
        return new ResponseEntity<>(matriculaServiceImpl.getMatriculas(), HttpStatus.OK);
    }

    @GetMapping("/{idMatricula}")
    public ResponseEntity<Matricula> getMatriculaById(@PathVariable int idMatricula) {
        Optional<Matricula> matricula = matriculaServiceImpl.getMatriculaById(idMatricula);
        if (matricula.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(matricula.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{idMatricula}")
    public ResponseEntity<Void> deletematricula(@PathVariable int idMatricula) {
        Optional<Matricula> matricula = matriculaServiceImpl.getMatriculaById(idMatricula);
        if (matricula.isPresent()) {
            matriculaServiceImpl.deleteMatricula(matricula.get().getIdMatricula());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
