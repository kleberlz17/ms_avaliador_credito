package kleberlz.msavaliadorcredito.service;


import java.util.List;

import org.springframework.stereotype.Service;

import kleberlz.msavaliadorcredito.config.CartoesResourceClient;
import kleberlz.msavaliadorcredito.config.ClienteResourceClient;
import kleberlz.msavaliadorcredito.model.CartaoClienteDTO;
import kleberlz.msavaliadorcredito.model.DadosClienteDTO;
import kleberlz.msavaliadorcredito.model.SituacaoCliente;

@Service
public class AvaliadorCreditoService {
	
	private final ClienteResourceClient clientesClient;
	private final CartoesResourceClient cartoesClient;
	
	public AvaliadorCreditoService(ClienteResourceClient clientesClient, CartoesResourceClient cartoesClient) {
		this.clientesClient = clientesClient;
		this.cartoesClient = cartoesClient;
	}
	
	public SituacaoCliente obterSituacaoCliente(String cpf) {
		// obterDadosCliente -MSCLIENTES
		// obter cartoes do cliente -MSCARTOES
		
		DadosClienteDTO dadosClienteDTO = clientesClient.dadosCliente(cpf);
		List<CartaoClienteDTO> cartoesClienteDTO = cartoesClient.buscarCartoesPorCliente(cpf);
		
		return SituacaoCliente
				.builder()
				.cliente(dadosClienteDTO)
				.cartoes(cartoesClienteDTO)
				.build();
		
	}

}
