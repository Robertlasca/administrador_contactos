package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.entities.Contacto;
import com.smart.entities.Usuario;
import com.smart.repositorys.IUsuarioRepository;

@Controller
public class HomeController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

}
