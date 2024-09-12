package com.itsqmet.gestion_productos.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.gestion_productos.modelos.Curso;
import com.itsqmet.gestion_productos.servicios.impl.CursoServiceImpl;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoServiceImpl cursoServiceImpl;

    @PostMapping("path")
    public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso) {
        try {
            Curso savedCurso = cursoServiceImpl.saveCurso(curso);
            return new ResponseEntity<>(savedCurso, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<Curso> updateCurso(@RequestBody Curso curso) {
        try {
            Curso updatedCurso = cursoServiceImpl.updateCurso(curso);
            return new ResponseEntity<>(updatedCurso, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getAllCurso() {
        return new ResponseEntity<>(cursoServiceImpl.getCursos(), HttpStatus.OK);
    }

    @GetMapping("/{idCurso}")
    public ResponseEntity<Curso> getCursoById(@PathVariable int idCurso) {
        Optional<Curso> curso = cursoServiceImpl.getCursoById(idCurso);
        if (curso.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(curso.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{idCurso}")
    public ResponseEntity<Void> deleteCurso(@PathVariable int idCurso) {
        Optional<Curso> curso = cursoServiceImpl.getCursoById(idCurso);
        if (curso.isPresent()) {
            cursoServiceImpl.deleteCurso(curso.get().getIdCurso());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
