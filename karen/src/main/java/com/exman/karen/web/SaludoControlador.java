package com.exman.karen.web;

import com.exman.karen.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class SaludoControlador {

    private PersonaServicio personaServicio;

    @Autowired
    public SaludoControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }
        @GetMapping("/saludo")
        public String saludo() {
            return personaServicio.saludo();
        }
}

