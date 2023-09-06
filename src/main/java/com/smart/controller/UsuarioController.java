package com.smart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.entities.Usuario;
import com.smart.repositorys.IUsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository userRepository;

	@RequestMapping("/index")
	public String dashboard(Model model,Principal principal) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Obtener los roles del usuario autenticado
        if (authentication != null && authentication.getAuthorities() != null) {
            for (GrantedAuthority authority : authentication.getAuthorities()) {
                String role = authority.getAuthority();
                System.out.println("Rol del usuario: " + role);
                // Puedes realizar la lógica de autorización basada en el rol aquí
            }
        }
        String userName = principal.getName();
        System.out.println("USERNAME"+userName);
		System.out.print("Si entre");
		Usuario usuario= userRepository.findByEmail(userName).get();
		model.addAttribute("user", usuario);
		
		System.out.println("Usuario "+usuario);
		
		return "user/usuario_dashboard";
	}
	
	

}
