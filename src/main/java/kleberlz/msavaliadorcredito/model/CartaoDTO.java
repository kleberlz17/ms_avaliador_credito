package kleberlz.msavaliadorcredito.model;

import java.math.BigDecimal;

public class CartaoDTO {
	private Long id;
	private String nome;
	private String bandeira;
	private BigDecimal limite;
	
	public CartaoDTO(Long id, String nome, String bandeira, BigDecimal limite) {
		this.id = id;
		this.nome = nome;
		this.bandeira = bandeira;
		this.limite = limite;
	}
	
	public CartaoDTO() {
		
	}

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

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "CartaoDTO [id=" + id + ", nome=" + nome + ", bandeira=" + bandeira + ", limite=" + limite + "]";
	}
	
	

}
