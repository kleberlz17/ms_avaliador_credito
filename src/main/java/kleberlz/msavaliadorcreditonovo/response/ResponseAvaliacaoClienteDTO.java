package kleberlz.msavaliadorcreditonovo.response;

import java.util.List;

public class ResponseAvaliacaoClienteDTO {
	
	private List<CartaoAprovadoResponseDTO> cartaoAprovado;
	
	public ResponseAvaliacaoClienteDTO(List<CartaoAprovadoResponseDTO> cartaoAprovado) {
		this.cartaoAprovado = cartaoAprovado;
	}

	public List<CartaoAprovadoResponseDTO> getCartaoAprovado() {
		return cartaoAprovado;
	}

	public void setCartaoAprovado(List<CartaoAprovadoResponseDTO> cartaoAprovado) {
		this.cartaoAprovado = cartaoAprovado;
	}
}
