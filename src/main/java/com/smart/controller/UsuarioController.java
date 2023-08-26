package com.smart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@RequestMapping(path="/index")
	public String dashboard() {
		return "user/usuario_dashboard";
	}
}
