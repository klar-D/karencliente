package com.exman.karen.web;

import com.exman.karen.modelo.Persona;
import com.exman.karen.servicio.PersonaServicio;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
@Data
@Named
@Scope(value = "session")
public class PersonaBean implements Serializable {
    private final static long SERIALIZABLEVERSIONUID = -1L;
    private Integer id;
    private String refTipoPersona;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private List<Persona> lista;


    private PersonaServicio personaServicio;

    @PostConstruct
    public void init() {
        obtener();
    }

    @Autowired
    public PersonaBean(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    public void limpiar() {
        refTipoPersona = null;
        primerNombre = null;
        segundoNombre = null;
        primerApellido = null;
        segundoApellido = null;
        fechaNacimiento = null;
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo() {
        addMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Registro Guardado");
    }

    public void obtener() {
        try {
            lista = Arrays.asList(personaServicio.obtenerTodo());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public void guardar() {
        try {
            Persona oNuevo = new Persona();
            oNuevo.setPrimerNombre(primerNombre);
            oNuevo.setSegundoNombre(segundoNombre);
            oNuevo.setPrimerApellido(primerApellido);
            oNuevo.setSegundoApellido(segundoApellido);
            oNuevo.setFechaNacimiento(fechaNacimiento);
            oNuevo.setRefTipoPersona(refTipoPersona);

            personaServicio.guardar(oNuevo);

            obtener();
            showInfo();
            limpiar();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
