package kleberlz.msavaliadorcredito.model;

import java.util.List;

import lombok.Builder;

@Builder
public class SituacaoCliente {
	
	private DadosClienteDTO cliente;
	private List<CartaoClienteDTO> cartoes;
	
	public SituacaoCliente(DadosClienteDTO cliente, List<CartaoClienteDTO> cartoes) {
		this.cliente = cliente;
		this.cartoes = cartoes;
	}
	
	public SituacaoCliente() {
		
	}

	public DadosClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(DadosClienteDTO cliente) {
		this.cliente = cliente;
	}

	public List<CartaoClienteDTO> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoClienteDTO> cartoes) {
		this.cartoes = cartoes;
	}

	@Override
	public String toString() {
		return "SituacaoCliente [cliente=" + cliente + ", cartoes=" + cartoes + "]";
	}

	
	
	

}
