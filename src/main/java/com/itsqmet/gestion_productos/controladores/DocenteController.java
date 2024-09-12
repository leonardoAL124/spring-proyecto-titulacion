package com.itsqmet.gestion_productos.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.gestion_productos.modelos.Docente;
import com.itsqmet.gestion_productos.servicios.impl.DocenteServiceImpl;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    DocenteServiceImpl docenteServiceImpl;

    @PostMapping("path")
    public ResponseEntity<Docente> saveDocente(@RequestBody Docente docente) {
        try {
            Docente savedDocente = docenteServiceImpl.saveDocente(docente);
            return new ResponseEntity<>(savedDocente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Docente> updateDocente(@RequestBody Docente docente) {
        try {
            Docente updatedDocente = docenteServiceImpl.updateDocente(docente);
            return new ResponseEntity<>(updatedDocente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Docente>> getAllDocentes() {
        return new ResponseEntity<>(docenteServiceImpl.getDocentes(), HttpStatus.OK);
    }

    @GetMapping("/{idDocente}")
    public ResponseEntity<Docente> getDocenteById(@PathVariable int idDocente) {
        Optional<Docente> docente = docenteServiceImpl.getDocenteById(idDocente);
        if (docente.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(docente.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{idDocente}")
    public ResponseEntity<Void> deleteDocente(@PathVariable int idDocente) {
        Optional<Docente> docente = docenteServiceImpl.getDocenteById(idDocente);
        if (docente.isPresent()) {
            docenteServiceImpl.deleteDocente(docente.get().getIdDocente());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
