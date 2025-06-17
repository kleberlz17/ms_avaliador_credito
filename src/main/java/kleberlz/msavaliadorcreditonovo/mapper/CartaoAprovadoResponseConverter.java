package kleberlz.msavaliadorcreditonovo.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import kleberlz.msavaliadorcreditonovo.dto.CartaoDTO;
import kleberlz.msavaliadorcreditonovo.response.CartaoAprovadoResponseDTO;

@Component
public class CartaoAprovadoResponseConverter {
	
	public CartaoAprovadoResponseDTO dtoParaDto(CartaoDTO cartaoDTO, Integer idade) {
		if (cartaoDTO.getLimite() == null) {
			return null;
		}
		
		BigDecimal idadeDecimal = BigDecimal.valueOf(idade);
		BigDecimal fator = idadeDecimal.divide(BigDecimal.valueOf(10));
		BigDecimal limiteAprovado = fator.multiply(cartaoDTO.getLimite());
		
		CartaoAprovadoResponseDTO dto = new CartaoAprovadoResponseDTO();
		dto.setCartao(cartaoDTO.getNome());
		dto.setBandeira(cartaoDTO.getBandeira());
		dto.setLimite(limiteAprovado);
		
		return dto;	
	}

}
