package com.generation.diretoDaTerra.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.generation.diretoDaTerra.Repository.CategoriaRepository;
import com.generation.diretoDaTerra.Util.Tipo;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	/**
	 * @author Daniel Reis
	 * @author Glaucya Nascimento
	 * @author Kaylaine Venancio 
	 * @author Luiz Melin
	 * @author Rebeca Marques
	 * @since 26/01/2022
	 * @see CategoriaController
	 * @see CategoriaRepository
	 */
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@NotNull
	@Size ( max = 150)
	private String descricao;
	
	@NotNull
	@Size (max = 100)
	private String categoria;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

}
