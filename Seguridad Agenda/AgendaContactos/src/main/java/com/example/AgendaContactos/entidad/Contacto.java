package com.example.AgendaContactos.entidad;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contactos")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Debe ingresar un nombre")
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @NotEmpty(message = "Debe ingresar su email")
    @Email
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @NotBlank(message = "Debe ingresar su celular")
    @Column(name = "celular", nullable = false, length = 100)
    private String celular;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    @NotNull(message = "Debe ingresar su Fecha de Nacimiento")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;


    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    //metodo asignamos la echa de registro
    //me ayuda a asignar la echa Prepersist
    @PrePersist
    public void asignarFechaRegistros(){
        fechaRegistro = LocalDateTime.now();//toma el momento exacto que estamos registrando
    }
}

