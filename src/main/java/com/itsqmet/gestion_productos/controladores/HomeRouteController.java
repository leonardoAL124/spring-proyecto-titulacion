package com.itsqmet.gestion_productos.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeRouteController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    
}
