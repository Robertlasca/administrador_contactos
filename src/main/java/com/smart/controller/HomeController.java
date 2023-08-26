package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smart.entities.Contacto;
import com.smart.entities.Usuario;
import com.smart.helper.Message;
import com.smart.repositorys.IUsuarioRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@RequestMapping("/")
	public String home(Model model)
	
	{
		model.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	@RequestMapping("/about")
	public String about(Model model)
	
	{
		model.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	
	@RequestMapping("/signup")
	public String signup(Model model)
	
	{
		model.addAttribute("title", "Registro - Smart Contact Manager");
		model.addAttribute("usuario", new Usuario());
		
		
		return "signup";
	}
	
	//Metodo para registrar
	@PostMapping("/registrar")
	public String registroUsuario(
	        @javax.validation.Valid @ModelAttribute("usuario") Usuario usuario,
	        BindingResult result1,
	        @RequestParam(value = "agreement", defaultValue = "false") boolean acepto,
	        Model model,
	        RedirectAttributes mensaje
	) {
	    try {
	        if (!acepto) {
	            // Si no se aceptan los términos, mostrar un mensaje de alerta y redirigir
	            mensaje.addFlashAttribute("alerta", "¡Alerta!");
	            mensaje.addFlashAttribute("alertIcon", "error");
	            mensaje.addFlashAttribute("alertTitle", "Por favor");
	            mensaje.addFlashAttribute("alertMessage", "Acepta los términos y condiciones");
	            return "redirect:/signup";
	        } else {
	            if (result1.hasErrors()) {
	                // Si hay errores de validación, mostrar el formulario de registro nuevamente
	                // junto con los mensajes de error
	                model.addAttribute("usuario", usuario);
	                return "signup";
	            } else {
	                // Si no hay errores, proceder con el registro del usuario
	                usuario.setRole("USER");
	                usuario.setEnabled(true);
	                usuario.setImageUrl("default.png");

	                Usuario user = usuarioRepository.save(usuario);

	                // Mostrar un mensaje de éxito y redirigir
	                mensaje.addFlashAttribute("alerta", "¡Alerta!");
	                mensaje.addFlashAttribute("alertIcon", "success");
	                mensaje.addFlashAttribute("alertTitle", "Correcto");
	                mensaje.addFlashAttribute("alertMessage", "Has sido registrado");
	                return "redirect:/signup";
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Si ocurre una excepción, mostrar un mensaje de error y redirigir
	        model.addAttribute("usuario", usuario);
	        mensaje.addFlashAttribute("alerta", "¡Alerta!");
	        mensaje.addFlashAttribute("alertIcon", "error");
	        mensaje.addFlashAttribute("alertTitle", "Incorrecto");
	        mensaje.addFlashAttribute("alertMessage", "Error interno");
	        return "redirect:/signup";
	    }
	}

	
	
	
}
