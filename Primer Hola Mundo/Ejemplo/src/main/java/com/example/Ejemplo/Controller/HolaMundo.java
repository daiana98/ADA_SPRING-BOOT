package com.example.Ejemplo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {


    @GetMapping("/")
    public String HolaMundo(){

        return "Hola Mundo";

    }
}
