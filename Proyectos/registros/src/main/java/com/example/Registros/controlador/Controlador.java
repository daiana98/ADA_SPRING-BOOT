package com.example.Registros.controlador;

import com.example.Registros.entidad.Persona;
import com.example.Registros.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class Controlador {

    //Encargada de hacer una interaccion con las vistas y la parte logica que tenemos aca dentro d enuestro respectivo proyecto
    @Autowired
    private PersonaServicio personaServicio;

    //esto resderiza la lista con la ayuda del atributo model

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        //a la lista le asigne todas las personas
        List<Persona> personas = personaServicio.listarTodasLasPersonas();

        //se lo agrego al obj modelo su respectiva lista
        model.addAttribute("personas", personas);

        //va aretornar la lista personas
        return "index";

    }

    @GetMapping("/new")
    public String agregar(Model model){
        Persona persona = new Persona();

        model.addAttribute("persona", persona);

        return "crear_persona";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute("persona") Persona persona){
        personaServicio.guardarPersona(persona);

        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditar(@PathVariable Integer id, Model model){

        model.addAttribute("persona", personaServicio.obtenerPorId(id));

        return "editar_persona";//retrnaos un omulario persona
    }

    //ModelAtribute -> para passar un atributo o un objeto
    @PostMapping("/editar/{id}")
    public String actualizarPersona(@PathVariable Integer id, @ModelAttribute("persona") Persona persona){

        //estoy modelando mnuevamente un atributo
        //obtener el objeto que coincida con el id
//persona es lo que ingerso en la pagina  y persona existente es lo que ya haya en la BD

        Persona personaExistente = personaServicio.obtenerPorId(id);

        personaExistente.setId(id);
        personaExistente.setNombre(persona.getNombre());
        personaExistente.setTelefono(persona.getTelefono());

        personaServicio.actualizarPersona(personaExistente);

        return "redirect:/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Integer id){
        personaServicio.eliminarPersona(id);

        return "redirect:/listar";
    }



}
