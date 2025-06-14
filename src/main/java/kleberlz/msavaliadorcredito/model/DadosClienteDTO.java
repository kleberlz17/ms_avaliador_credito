package kleberlz.msavaliadorcredito.model;

public class DadosClienteDTO {
	
	private Long id;
	private String nome;
	private Integer idade;
	
	public DadosClienteDTO(Long id, String nome, Integer idade) {
		this.id = id;
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

	@Override
	public String toString() {
		return "DadosClienteDTO [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}

	

}
