package com.example.Registros.repositorio;

import com.example.Registros.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//gracias a este contenedor lo puedo inyectar
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {




}
