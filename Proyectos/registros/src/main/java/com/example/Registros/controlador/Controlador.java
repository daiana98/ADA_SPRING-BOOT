package com.example.Registros.controlador;

import com.example.Registros.entidad.Persona;
import com.example.Registros.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Controlador {

    //Encargada de hacer una interaccion con las vistas y la parte logica que tenemos aca dentro d enuestro respectivo proyecto
    @Autowired
    private PersonaServicio personaServicio;

    //esto resderiza la lista con la ayuda del atributo model

    @GetMapping("/listar")
    public String listar(Model model){
        //a la lista le asigne todas las personas
        List<Persona> personas = personaServicio.listarTodasLasPersonas();

        //se lo agrego al obj modelo su respectiva lista
        model.addAttribute("personas", personas);

        //va aretornar la lista personas
        return "index";

    }



}
