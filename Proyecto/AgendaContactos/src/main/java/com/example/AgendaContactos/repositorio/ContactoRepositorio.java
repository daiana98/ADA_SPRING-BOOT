package com.example.AgendaContactos.repositorio;

import com.example.AgendaContactos.entidad.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Integer> {
}
