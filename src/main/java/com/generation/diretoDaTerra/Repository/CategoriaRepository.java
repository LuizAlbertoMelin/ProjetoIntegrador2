package com.generation.diretoDaTerra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.diretoDaTerra.Model.Categoria;



public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{
	

	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
	
}
