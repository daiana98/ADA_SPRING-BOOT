package com.example.AgendaContactos.controlador;

import com.example.AgendaContactos.entidad.Contacto;
import com.example.AgendaContactos.servicio.ContactoServicio;
import com.example.AgendaContactos.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContactoControlador {
    @Autowired
    private ContactoServicio contactoServicio;


    @Autowired
    private UsuarioServicio usuarioServicio;

    //esto resderiza la lista con la ayuda del atributo model


    @GetMapping("/login")
    public String iniciarSesion(){
        return "login";
    }

    @GetMapping("/")
    public String verPaginaDeInicio(Model modelo){
        modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());

        return "index";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }


    @GetMapping("/listar")
    public String listar(Model modelo){
        List<Contacto> contactos = contactoServicio.listarTodosLosContactos();

        modelo.addAttribute("contactos",contactos);

        return "lista";
    }


    @GetMapping("/nuevo")
    public String mostrarFormularioDeRegistrarContacto(Model modelo){
        modelo.addAttribute("contacto", new Contacto());

        return "nuevo";
    }
    //biding manejo de errores con redirectAtribute, para recibir los errores de validacion
    @PostMapping("/save")
    public String guardarContacto(@Validated Contacto contacto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model modelo){

        if (bindingResult.hasErrors()){//true errores
            modelo.addAttribute("contacto",contacto);
            return "nuevo";
        }

        contactoServicio.guardarContacto(contacto);
        redirectAttributes.addFlashAttribute("msgExito", "El contacto ha sido agregado con exito");

        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioDeEditarContacto(@PathVariable Integer id, Model modelo){

        Contacto contacto = contactoServicio.obtenerContactoPorId(id);//recuperamos el contacto
        //modelamos el contacto
        modelo.addAttribute("contacto", contacto);

        //retornamos una vissta retornamos el ormualrio edita html
        return "editar";
    }

    //un post por que vamos a alojar un dato el que envia a la BD, path variable nos ayuda a modelar el id, validated para validar el objeto contacto
    //redirect result releja los errores
    @PostMapping("/editar/{id}")
    public String actualizarContacto(@PathVariable Integer id, @Validated Contacto contacto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        Contacto contactoAbd = contactoServicio.obtenerContactoPorId(id);
        if (bindingResult.hasErrors()){//nos ayuda a saber si hubo error en el omulario
            //
            model.addAttribute("contacto", contacto);

            return "editar";
        }
        //modelamos el objeto en web
        contactoAbd.setNombre(contacto.getNombre());
        contactoAbd.setCelular(contacto.getCelular());
        contactoAbd.setEmail(contacto.getEmail());
        contactoAbd.setFechaNacimiento(contacto.getFechaNacimiento());

        //guardamos el contacto ne el ormulario
        contactoServicio.actualizarContacto(contactoAbd);

        //redirecionamos para que sepa que esta ok
        redirectAttributes.addFlashAttribute("msgExito", "El contacto se ha actualizado con exito");

        //returnamos la pagina inicial con el / por uque esa es la incial
        return "redirect:/listar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarContacto(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        //muestra ek mensajito el redirect atribute aca lo usaremos para saber si esta ssgguro de que desea eliminar
        Contacto contacto = contactoServicio.obtenerContactoPorId(id);

        contactoServicio.Eliminar(contacto);

        redirectAttributes.addFlashAttribute("msgExito", "El contacto se ha eliminado con Exito");

        //retornamos el index
        return "redirect:/listar";
    }
}
