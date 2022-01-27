package com.generation.diretoDaTerra.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.diretoDaTerra.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);

}
