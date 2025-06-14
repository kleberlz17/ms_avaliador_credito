package kleberlz.msavaliadorcredito.model;

import java.util.List;

public class RetornoAvaliacaoClienteDTO {
	private List<CartaoAprovadoDTO> cartoesAprovados;
	
	public RetornoAvaliacaoClienteDTO(List<CartaoAprovadoDTO> cartoesAprovados) {
		this.cartoesAprovados = cartoesAprovados;
	}
	
	public RetornoAvaliacaoClienteDTO() {
		
	}

	public List<CartaoAprovadoDTO> getCartoesAprovados() {
		return cartoesAprovados;
	}

	public void setCartoesAprovados(List<CartaoAprovadoDTO> cartoesAprovados) {
		this.cartoesAprovados = cartoesAprovados;
	}

	@Override
	public String toString() {
		return "RetornoAvaliacaoClienteDTO [cartoesAprovados=" + cartoesAprovados + "]";
	}
	
	

}
