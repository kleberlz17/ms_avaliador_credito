package kleberlz.msavaliadorcreditonovo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CartaoDTO {

	@Min(1)
	@Max(999999)
	private Long id;

	@NotBlank(message = "O nome do cartão não deve estar em branco.")
	@Size(min = 3, max = 100, message = "Fora do tamanho padrão permitido.")
	private String nome;

	@NotBlank(message = "A bandeira do cartão não deve estar em branco.")
	@Size(min = 3, max = 100, message = "Fora do tamanho padrão permitido.")
	private String bandeira;

	@NotNull(message = "O limite não deve ser nulo.")
	private BigDecimal limite;
	
	public CartaoDTO(String nome, String bandeira, BigDecimal limite) {
		this.nome = nome;
		this.bandeira = bandeira;
		this.limite = limite;
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
	
	
}
