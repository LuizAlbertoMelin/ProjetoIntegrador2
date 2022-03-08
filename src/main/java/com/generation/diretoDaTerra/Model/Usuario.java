package com.generation.diretoDaTerra.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.diretoDaTerra.Controller.UsuarioController;
import com.generation.diretoDaTerra.Repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Table(name = "tb_usuario")
public class Usuario {

	/**
	 * @author Daniel Reis
	 * @author Glaucya Nascimento
	 * @author Kaylaine Venancio 
	 * @author Luiz Melin
	 * @author Rebeca Marques
	 * @since 27/01/2022
	 * @see UsuarioController
	 * @see UsuarioRepository
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@NotBlank
	@Size(max = 100)
	private String nome;
	
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O atributo email é Obrigatório!")
	@Email(message = "O atributo email deve ser um email válido!")
	private String email;

	
	@NotBlank
	@Size(max = 100)
	private String senha;
	
	private String foto;
	
	private String tipo;
	


	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produtos = new ArrayList<>();
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
