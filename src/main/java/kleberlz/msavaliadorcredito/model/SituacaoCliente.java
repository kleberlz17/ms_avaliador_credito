package kleberlz.msavaliadorcredito.model;

import java.util.List;

import lombok.Builder;

@Builder
public class SituacaoCliente {
	
	private DadosClienteDTO cliente;
	private List<CartaoCliente> cartoes;
	
	public SituacaoCliente(DadosClienteDTO cliente, List<CartaoCliente> cartoes) {
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

	public List<CartaoCliente> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoCliente> cartoes) {
		this.cartoes = cartoes;
	}

	@Override
	public String toString() {
		return "SituacaoCliente [cliente=" + cliente + ", cartoes=" + cartoes + "]";
	}

	
	
	

}
