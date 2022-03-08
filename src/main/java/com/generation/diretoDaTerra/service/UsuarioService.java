package com.generation.diretoDaTerra.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.diretoDaTerra.Model.UserLogin;
import com.generation.diretoDaTerra.Model.Usuario;
import com.generation.diretoDaTerra.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario email) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(email.getSenha());
		email.setSenha(senhaEncoder);
		
		return repository.save(email);
	}
	
	public Optional<UserLogin> Logar(Optional<UserLogin> email){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByEmail(email.get().getEmail());
		
		if(usuario.isPresent()) {
			if(encoder.matches(email.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = email.get().getEmail()+ ":" + email.get().getSenha();
				byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String (encodeAuth);
				
				email.get().setToken(authHeader);
				email.get().setId(usuario.get().getId()); 
				email.get().setNome(usuario.get().getNome());
				email.get().setFoto(usuario.get().getFoto());
				email.get().setTipo(usuario.get().getTipo());
				
				return email;
				
			}
				
		}
		return null;
	}
}
