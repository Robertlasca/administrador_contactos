package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String registroUsuario(Usuario usuario,@RequestParam(value="agreement",defaultValue = "false") boolean acepto,Model model,RedirectAttributes mensaje )
	{
		try {
			if(!acepto) {
				System.out.println("No aceptaste los terminos");
				mensaje.addFlashAttribute("alerta", "¡Alerta!");
				mensaje.addFlashAttribute("alertIcon", "error");
				mensaje.addFlashAttribute("alertTitle", "Por favor");
				mensaje.addFlashAttribute("alertMessage", "Acepta los terminos y condiciones");
				return "redirect:/signup";

				
				
			}else {
				System.out.println("Si aceptaste los terminos");
				usuario.setRole("USER");
				usuario.setEnabled(true);
				usuario.setImageUrl("default.png");
				
				Usuario user= usuarioRepository.save(usuario);
				
				
				System.out.println("Mi usuario"+usuario.toString());
				System.out.println("Valor de la variable"+acepto);
				
				model.addAttribute("usuario",new Usuario());
				mensaje.addFlashAttribute("alerta", "¡Alerta!");
				mensaje.addFlashAttribute("alertIcon", "success");
				mensaje.addFlashAttribute("alertTitle", "Correcto");
				mensaje.addFlashAttribute("alertMessage", "Haz sido registrado");
				return "redirect:/signup";
				//return "signup";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", usuario);
			mensaje.addFlashAttribute("alerta", "¡Alerta!");
			mensaje.addFlashAttribute("alertIcon", "error");
			mensaje.addFlashAttribute("alertTitle", "Incorrecto");
			mensaje.addFlashAttribute("alertMessage", "Error interno");
			//return "signup";
			return "redirect:/signup";
		}
		
		
	}
	
	
	
}
