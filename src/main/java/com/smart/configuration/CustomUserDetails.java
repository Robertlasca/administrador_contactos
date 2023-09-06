package com.smart.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.smart.entities.Usuario;
import com.smart.repositorys.IUsuarioRepository;

@Service
public class CustomUserDetails implements UserDetailsService{
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	private Logger log= (Logger) LoggerFactory.getLogger(UserDetailsService.class);
	
	private Usuario userDetail;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Este es el username");
		Optional<Usuario> optionalUser=usuarioRepository.findByEmail(username);
		if (optionalUser.isPresent()) {
			log.info("Esto es el id del usuario: {}", optionalUser.get().getId());
			Usuario usuario= optionalUser.get();
			return User.builder()
                    .username(usuario.getEmail())
                    .password(usuario.getPasword())
                    .roles(usuario.getRole())
                    .build();
		}else {
			throw new UsernameNotFoundException("Usuario no encontrado");			
		}
	}
	

}
