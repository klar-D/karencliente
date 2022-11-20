package com.exman.karen.servicio;

import com.exman.karen.modelo.Persona;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PersonaServicio {

    private final RestTemplate restTemplate;

    public String saludo() {
        String cadena = restTemplate.getForObject("http://localhost:8080/firstapi_karen/saludorest/hola", String.class);
        return cadena;
    }

    public Persona[] obtenerTodo() {
         Persona[] personaList = restTemplate.getForObject("http://localhost:8080/firstapi/personas/todo", Persona[].class);
        return personaList;
    }

    public void guardar(Persona persona) {
        restTemplate.postForObject("http://localhost:8080/firstapi/personas/guardar", persona , Persona.class);
    }

}
