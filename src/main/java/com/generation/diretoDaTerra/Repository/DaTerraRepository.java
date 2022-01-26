package com.generation.diretoDaTerra.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.diretoDaTerra.Model.DaTerra;
import com.generation.diretoDaTerra.Util.Tipo;

public interface DaTerraRepository  extends JpaRepository<DaTerra, Long>{
	public List<DaTerra> findAllByTipoContainingIgnoreCase(Tipo tipo);
	
}
