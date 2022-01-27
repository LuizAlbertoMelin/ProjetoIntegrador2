package com.generation.diretoDaTerra.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.diretoDaTerra.Util.Disponibilidade;

@Entity
@Table(name = "tb_produto")
public class Produto {
	

	/**
	 * @author Daniel Reis
	 * @author Glaucya Nascimento
	 * @author Kaylaine Venancio 
	 * @author Luiz Melin
	 * @author Rebeca Marques
	 * @since 27/01/2022
	 * @see ProdutoController
	 * @see ProdutoRepository
	 */
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(max = 100)
	private String nome;
	
	@NotNull
	@Digits(integer=4, fraction=2)
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	private Disponibilidade disponibilidade;
	
	@NotBlank
	@Size(max = 45)
	private String produtor;
	
	@NotNull
	@Digits(integer=10, fraction=2)
	private BigDecimal quantidadekg;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario usuario;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(Disponibilidade disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public BigDecimal getQuantidadekg() {
		return quantidadekg;
	}

	public void setQuantidadekg(BigDecimal quantidadekg) {
		this.quantidadekg = quantidadekg;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
			
	

}
