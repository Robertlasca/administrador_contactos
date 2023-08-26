package com.smart.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smart.entities.Usuario;
import com.smart.repositorys.IUsuarioRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private IUsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user=userRepository.findByEmail(username).get();
		
		if(user==null) {
			throw new UsernameNotFoundException("Este usuario no existe");
		}
		
		CustomUserDetails custom= new CustomUserDetails(user);
		return custom;
	}

}
