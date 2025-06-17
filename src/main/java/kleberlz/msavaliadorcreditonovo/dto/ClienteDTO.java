package kleberlz.msavaliadorcreditonovo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ClienteDTO {
	
	@Min(1)
	@Max(999999)
	private Long id;
	
	@NotBlank(message = "O nome do cliente não deve estar em branco.")
	@Size(min = 3, max = 100, message = "Fora do tamanho padrão permitido.")
	private String nome;
	
	@NotNull(message = "A idade não deve ser nula.")
	private Integer idade;
	
	public ClienteDTO(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
