package com.itsqmet.gestion_productos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.gestion_productos.modelos.Matricula;
import com.itsqmet.gestion_productos.servicios.impl.MatriculaServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/matricula")
public class MatriculaController {

    @Autowired
    MatriculaServiceImpl matriculaServiceImpl;

    // CREATE
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("matricula", new Matricula());
        return "matricula/form";
    }
    
    @PostMapping("/form")
    public String saveMatricula(Matricula matricula) {
        matriculaServiceImpl.saveMatricula(matricula);
        return "redirect:/matricula/lista";
    }
    
    // READ
    @GetMapping("/lista")
    public String getAllMatriculas(Model model) {
        List<Matricula> matriculas = matriculaServiceImpl.getMatriculas();
        model.addAttribute("matriculas", matriculas);
        return "matricula/lista";
    }
    
    // UPDATE
    @GetMapping("/editar/{id}")
    public String updateMatricula(@PathVariable int id, Model model) {
        Matricula matricula = matriculaServiceImpl.getMatriculaById(id).get();
        model.addAttribute("matricula", matricula);
        System.out.println(matricula);
        return "matricula/form";
    }
    
    // DELETE
    @GetMapping("/eliminar/{id}")
    public String deleteMatricula(@PathVariable int id) {
        matriculaServiceImpl.deleteMatricula(id);
        return "redirect:/matricula/lista";
    }
    

}
