package com.generation.diretoDaTerra.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.diretoDaTerra.Model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		public List<Usuario> findAllByNomeContainingIgnoreCase (String email);
		public Optional<Usuario> findByEmail(String email);
}