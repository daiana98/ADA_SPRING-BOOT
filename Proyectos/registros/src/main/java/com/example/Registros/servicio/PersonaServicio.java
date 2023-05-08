package com.example.Registros.servicio;

import com.example.Registros.entidad.Persona;

import java.util.List;

public interface PersonaServicio {

    //crear el cuerpo abstracto del metodo
    public List<Persona>listarTodasLasPersonas();

    public Persona guardarPersona(Persona persona);

    public Persona obtenerPorId(Integer id);

    public Persona actualizarPersona(Persona persona);

    public void eliminarPersona(Integer id);

}
