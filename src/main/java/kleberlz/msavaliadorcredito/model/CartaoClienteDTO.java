package kleberlz.msavaliadorcredito.model;

import java.math.BigDecimal;

public class CartaoClienteDTO {
	
	private String nome;
	private String bandeira;
	private BigDecimal limite;
	
	public CartaoClienteDTO(String nome, String bandeira, BigDecimal limite) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.limite = limite;
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
		return "CartaoClienteDTO [nome=" + nome + ", bandeira=" + bandeira + ", limite=" + limite + "]";
	}



}
