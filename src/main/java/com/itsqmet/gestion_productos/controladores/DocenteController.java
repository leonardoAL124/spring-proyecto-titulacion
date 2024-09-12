package com.itsqmet.gestion_productos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.gestion_productos.modelos.Docente;
import com.itsqmet.gestion_productos.servicios.impl.DocenteServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    @Autowired
    DocenteServiceImpl docenteServiceImpl;

    // CREATE
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("docente", new Docente());
        return "docente/form";
    }
    
    @PostMapping("/form")
    public String createDocente(Docente docente) {
        docenteServiceImpl.saveDocente(docente);
        return "redirect:/docente/lista";
    }
    
    // READ
    @GetMapping("/lista")
    public String getAllDocentes(Model model) {
        List<Docente> docentes = docenteServiceImpl.getDocentes();
        model.addAttribute("docentes", docentes);
        return "docente/lista";
    }
    
    // UPDATE
    @GetMapping("/editar/{id}")
    public String updateDocente(@PathVariable int id, Model model) {
        Docente docente = docenteServiceImpl.getDocenteById(id).get();
        model.addAttribute("docente", docente);
        return "docente/form";
    }
    
    // DELETE
    @GetMapping("/eliminar/{id}")
    public String deleteDocente(@PathVariable int id) {
        docenteServiceImpl.deleteDocente(id);
        return "redirect:/docente/lista";
    }
    

}
