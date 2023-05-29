package com.example.AgendaContactos.servicio;

import com.example.AgendaContactos.entidad.Contacto;
import java.util.List;
public interface ContactoServicio {

    public List<Contacto> listarTodosLosContactos();

    public Contacto guardarContacto(Contacto contacto);

    public Contacto obtenerContactoPorId(Integer id);

    public Contacto actualizarContacto(Contacto contacto);

    public void Eliminar(Contacto contacto);
}
