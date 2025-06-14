package kleberlz.msavaliadorcredito.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import feign.FeignException;
import kleberlz.msavaliadorcredito.config.CartoesResourceClient;
import kleberlz.msavaliadorcredito.config.ClienteResourceClient;
import kleberlz.msavaliadorcredito.exception.DadosClienteNotFoundException;
import kleberlz.msavaliadorcredito.exception.ErroComunicacaoMicroservicesException;
import kleberlz.msavaliadorcredito.model.CartaoAprovadoDTO;
import kleberlz.msavaliadorcredito.model.CartaoClienteDTO;
import kleberlz.msavaliadorcredito.model.CartaoDTO;
import kleberlz.msavaliadorcredito.model.DadosClienteDTO;
import kleberlz.msavaliadorcredito.model.RetornoAvaliacaoClienteDTO;
import kleberlz.msavaliadorcredito.model.SituacaoCliente;

@Service
public class AvaliadorCreditoService {
	
	private final ClienteResourceClient clientesClient;
	private final CartoesResourceClient cartoesClient;
	
	public AvaliadorCreditoService(ClienteResourceClient clientesClient, CartoesResourceClient cartoesClient) {
		this.clientesClient = clientesClient;
		this.cartoesClient = cartoesClient;
	}
	
	public SituacaoCliente obterSituacaoCliente(String cpf) throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {
		// obterDadosCliente -MSCLIENTES
		// obter cartoes do cliente -MSCARTOES
		try {
		DadosClienteDTO dadosClienteDTO = clientesClient.dadosCliente(cpf);
		List<CartaoClienteDTO> cartoesClienteDTO = cartoesClient.buscarCartoesPorCliente(cpf);
		
		return SituacaoCliente
				.builder()
				.cliente(dadosClienteDTO)
				.cartoes(cartoesClienteDTO)
				.build();
		} catch (FeignException.FeignClientException e) {
			int status = e.status();
			if(HttpStatus.NOT_FOUND.value() == status) {
				throw new DadosClienteNotFoundException();
			}
			
			throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);	
		}
	}
	
	public RetornoAvaliacaoClienteDTO realizarAvaliacao(String cpf, Long renda) throws DadosClienteNotFoundException, ErroComunicacaoMicroservicesException {
		try {
			DadosClienteDTO dadosClienteDTO = clientesClient.dadosCliente(cpf);
			List<CartaoDTO> cartoes = cartoesClient.buscarCartoesRendaAte(renda);
			
			var listaCartoesAprovados = cartoes.stream().filter(cartao -> cartao.getLimite() != null)
					.map(cartao -> {
				BigDecimal limite = cartao.getLimite();
				BigDecimal idadeBD = BigDecimal.valueOf(dadosClienteDTO.getIdade());
				var fator = idadeBD.divide(BigDecimal.valueOf(10));
				BigDecimal limiteAprovado = fator.multiply(limite);
				
				CartaoAprovadoDTO aprovado = new CartaoAprovadoDTO();
				aprovado.setCartao(cartao.getNome());
				aprovado.setBandeira(cartao.getBandeira());
				aprovado.setLimite(limiteAprovado);
				
				return aprovado;				
			}).collect(Collectors.toList());
			
			return new RetornoAvaliacaoClienteDTO(listaCartoesAprovados);
			
			
		} catch (FeignException.FeignClientException e) {
			int status = e.status();
			if(HttpStatus.NOT_FOUND.value() == status) {
				throw new DadosClienteNotFoundException();
			}
			throw new ErroComunicacaoMicroservicesException(e.getMessage(), status);
		}
		
	}

}
