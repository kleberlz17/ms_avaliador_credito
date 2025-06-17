package kleberlz.msavaliadorcreditonovo.response;

import java.util.List;
import kleberlz.msavaliadorcreditonovo.dto.ClienteDTO;
import lombok.Builder;

@Builder
public class SituacaoClienteResponseDTO {

	private ClienteDTO cliente;
	private List<CartaoResponseDTO> cartoes;
	
	public SituacaoClienteResponseDTO(ClienteDTO cliente, List<CartaoResponseDTO> cartoes) {
		this.cliente = cliente;
		this.cartoes = cartoes;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<CartaoResponseDTO> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoResponseDTO> cartoes) {
		this.cartoes = cartoes;
	}

	
}
