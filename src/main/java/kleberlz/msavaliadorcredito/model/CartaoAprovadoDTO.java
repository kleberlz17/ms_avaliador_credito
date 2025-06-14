package kleberlz.msavaliadorcredito.model;

import java.math.BigDecimal;

public class CartaoAprovadoDTO {
	private String cartao;
	private String bandeira;
	private BigDecimal limite;
	
	public CartaoAprovadoDTO(String cartao, String bandeira, BigDecimal limite) {
		this.cartao = cartao;
		this.bandeira = bandeira;
		this.limite = limite;
	}
	
	public CartaoAprovadoDTO() {
		
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	@Override
	public String toString() {
		return "CartaoAprovadoDTO [cartao=" + cartao + ", bandeira=" + bandeira + ", limite=" + limite + "]";
	}
	
	

}
