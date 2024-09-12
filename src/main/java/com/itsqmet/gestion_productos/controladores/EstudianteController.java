package com.itsqmet.gestion_productos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.itsqmet.gestion_productos.modelos.Estudiante;
import com.itsqmet.gestion_productos.servicios.impl.EstudianteServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    EstudianteServiceImpl estudianteServiceImpl;

    // CREATE
    // Mapear el formulario
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiante/form";
    }

    // Guardar el formulario en la DB
    @PostMapping("/form")
    public String saveEstudiante(Estudiante estudiante) {
        estudianteServiceImpl.saveEstudiante(estudiante);
        return "redirect:/estudiante/lista";
    }

    // READ
    // Obtener todos los estudiantes
    @GetMapping("/lista")
    public String getAllEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteServiceImpl.getEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiante/lista";
    }

    // UPDATE
    // Mapear el formulario - CON ID
    @GetMapping("/editar/{id}")
    public String showFormWithId(@PathVariable int id, Model model) {
        Estudiante estudiante = estudianteServiceImpl.getEstudianteById(id).get();
        model.addAttribute("estudiante", estudiante);
        return "estudiante/form";
    }

    // DELETE
    @GetMapping("/eliminar/{id}")
    public String deleteEstudiante(@PathVariable int id) {
        estudianteServiceImpl.deleteEstudiante(id);
        return "redirect:/estudiante/lista";
    }

}
