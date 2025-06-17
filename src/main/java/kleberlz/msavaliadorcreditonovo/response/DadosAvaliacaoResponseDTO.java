package kleberlz.msavaliadorcreditonovo.response;

import java.math.BigDecimal;

public class DadosAvaliacaoResponseDTO {
	
	private String cpf;
	private BigDecimal renda;
	
	public DadosAvaliacaoResponseDTO(String cpf, BigDecimal renda) {
		this.cpf = cpf;
		this.renda = renda;
	}

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
