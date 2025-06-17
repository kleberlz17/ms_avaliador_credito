package kleberlz.msavaliadorcreditonovo.response;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CartaoResponseDTO {

	@NotBlank(message = "O nome do cartão não deve estar em branco.")
	@Size(min = 3, max = 100, message = "Fora do tamanho padrão permitido.")
	private String nome;
	
	@NotBlank(message = "A bandeira do cartão não deve estar em branco.")
	@Size(min = 3, max = 100, message = "Fora do tamanho padrão permitido.")
	private String bandeira;
	
	@NotNull(message = "O limite não deve ser nulo.")
	private BigDecimal limite;

	public CartaoResponseDTO(String nome, String bandeira, BigDecimal limite) {
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
	
}
