package com.exman.karen.modelo;

import lombok.Data;

import java.util.Date;

@Data
public class Persona {
    private Integer id;
    private String refTipoPersona;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;

}
