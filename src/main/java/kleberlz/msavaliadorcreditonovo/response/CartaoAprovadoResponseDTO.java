package kleberlz.msavaliadorcreditonovo.response;

import java.math.BigDecimal;

public class CartaoAprovadoResponseDTO {

	private String cartao;
	private String bandeira;
	private BigDecimal limite;
	
	public CartaoAprovadoResponseDTO(String cartao, String bandeira, BigDecimal limite) {
		this.cartao = cartao;
		this.bandeira = bandeira;
		this.limite = limite;
	}
	
	public CartaoAprovadoResponseDTO() {
		
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
	
	
}
