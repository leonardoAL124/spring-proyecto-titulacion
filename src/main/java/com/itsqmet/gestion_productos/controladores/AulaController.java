package com.itsqmet.gestion_productos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.itsqmet.gestion_productos.modelos.Aula;
import com.itsqmet.gestion_productos.servicios.impl.AulaServiceImpl;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

// Declaramos que la clase es un controlador
@Controller
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    AulaServiceImpl aulaServiceImpl;

    // CREATE
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("aula", new Aula());
        return "aula/form";
    }
    
    @PostMapping("/form")
    public String saveAula(Aula aula) {
        aulaServiceImpl.saveAula(aula);
        return "redirect:/aula/lista";
    }

    // READ
    @GetMapping("/lista")
    public String getAllAulas(Model model) {
        List<Aula> aulas = aulaServiceImpl.getAulas();
        model.addAttribute("aulas", aulas);
        return "aula/lista";
    }
    
    // UPDATE
    @GetMapping("/editar/{id}")
    public String udateAula(@PathVariable int id, Model model) {
        Aula aula = aulaServiceImpl.getAulaById(id).get();
        model.addAttribute("aula", aula);
        return "aula/form";
    }

    // DELETE
    @GetMapping("/eliminar/{id}")
    public String deleteAula(@PathVariable int id) {
        aulaServiceImpl.deleteAula(id);
        return "redirect:/aula/lista";
    }
    
}
