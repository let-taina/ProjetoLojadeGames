package com.generation.lojadegames.model;







import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "tb_produtos")
public class Produto {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@NotBlank(message = "O nome do produto é obrigatório!") 
	@Size(min = 2, max = 100, message = "O nome do produto deve ter no mínimo 2 caracteres e no máximo 100.")
	private String nome;
	
	@NotBlank(message = "O atributo CONSOLE é obrigatório!")
	@Size(min = 2, max = 1000, message = "O atributo CONSOLE deve ter no mínimo 2 caracteres e no máximo 100 caracteres.")
	private String console;
	
	/*@Pattern(regexp = "\\d{4}/\\d{2}/\\d{2}" message="Favor informar a data de lançamento no formato yyyy-mm-dd")
	@Temporal(TemporalType.DATE)
	private  Date datalancamento;*/
	
	@JsonFormat(pattern= "yyyy-MM-dd") 
	private  LocalDate datalancamento;
	
	@ManyToOne //mts produtos p 1 categoria
	@JsonIgnoreProperties("produto") 
	private Categoria categoria; 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public LocalDate getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(LocalDate datalancamento) {
		this.datalancamento = datalancamento;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
		
		
}