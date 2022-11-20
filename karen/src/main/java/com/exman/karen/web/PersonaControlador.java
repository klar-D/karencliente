package com.exman.karen.web;

import com.exman.karen.modelo.Persona;
import com.exman.karen.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {

    private PersonaServicio personaServicio;

    @Autowired
    public PersonaControlador(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping("/todo")
    public Persona[] obtenerTodo() {
        return personaServicio.obtenerTodo();
    }

    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public void guardar(@RequestBody Persona persona) {
         personaServicio.guardar(persona);
    }

}
