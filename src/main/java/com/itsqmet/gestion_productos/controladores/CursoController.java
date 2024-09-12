package com.itsqmet.gestion_productos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.gestion_productos.modelos.Curso;
import com.itsqmet.gestion_productos.servicios.impl.CursoServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoServiceImpl cursoServiceImpl;

    // CREATE
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/form";
    }

    @PostMapping("/form")
    public String saveCurso(Curso curso) {
        cursoServiceImpl.saveCurso(curso);
        return "redirect:/curso/lista";
    }

    //READ
    @GetMapping("/lista")
    public String getAllCursos(Model model) {
        List<Curso> cursos = cursoServiceImpl.getCursos();
        model.addAttribute("cursos", cursos);
        return "curso/lista";
    }
    

    // UPDATE
    @GetMapping("/editar/{id}")
    public String updateCurso(@PathVariable int id, Model model) {
        Curso curso = cursoServiceImpl.getCursoById(id).get();
        model.addAttribute("curso", curso);
        return "curso/form";
    }
    
    // DELETE
    @GetMapping("/eliminar/{id}")
    public String deleteCurso(@PathVariable int id) {
        cursoServiceImpl.deleteCurso(id);
        return "redirect:/curso/lista";
    }

}
