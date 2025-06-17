package kleberlz.msavaliadorcreditonovo.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AvaliacaoClienteRequestDTO {
	
	@Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 números.")
	private String cpf; // do cliente
	
	@NotNull(message = "A renda não deve ser nula.")
	private BigDecimal renda; // cartão

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getRenda() {
		return renda;
	}

	public void setRenda(BigDecimal renda) {
		this.renda = renda;
	}

	
}
