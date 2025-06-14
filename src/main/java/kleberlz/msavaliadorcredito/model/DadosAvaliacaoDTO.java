package kleberlz.msavaliadorcredito.model;

public class DadosAvaliacaoDTO {

	private String cpf;
	private Long renda;
	
	public DadosAvaliacaoDTO(String cpf, Long renda) {
		this.cpf = cpf;
		this.renda = renda;
	}
	
	public DadosAvaliacaoDTO() {
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getRenda() {
		return renda;
	}

	public void setRenda(Long renda) {
		this.renda = renda;
	}

	@Override
	public String toString() {
		return "DadosAvaliacaoDTO [cpf=" + cpf + ", renda=" + renda + "]";
	}
	
	
}
