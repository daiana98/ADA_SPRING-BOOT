package com.example.Registros.servicio;

import com.example.Registros.entidad.Persona;
import com.example.Registros.repositorio.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImpPersonaServicio implements PersonaServicio{

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public List<Persona> listarTodasLasPersonas() {

        return personaRepositorio.findAll();
    }

    @Override
    public Persona guardarPersona(Persona persona) {
        return personaRepositorio.save(persona);
    }

    @Override
    public Persona obtenerPorId(Integer id) {
        return null;
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return null;
    }

    @Override
    public void eliminarPersona(Integer id) {

    }
    //va a implementar todos los metodos de la interaz

}
