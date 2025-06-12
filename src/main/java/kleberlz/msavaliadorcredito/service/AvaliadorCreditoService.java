package kleberlz.msavaliadorcredito.service;


import org.springframework.stereotype.Service;

import kleberlz.msavaliadorcredito.config.ClienteResourceClient;
import kleberlz.msavaliadorcredito.model.DadosClienteDTO;
import kleberlz.msavaliadorcredito.model.SituacaoCliente;

@Service
public class AvaliadorCreditoService {
	
	private final ClienteResourceClient clientesClient;
	
	public AvaliadorCreditoService(ClienteResourceClient clientesClient) {
		this.clientesClient = clientesClient;
	}
	
	public SituacaoCliente obterSituacaoCliente(String cpf) {
		// obterDadosCliente -MSCLIENTES
		// obter cartoes do cliente -MSCARTOES
		
		DadosClienteDTO dadosClienteDTO = clientesClient.dadosCliente(cpf);
		
		return SituacaoCliente
				.builder()
				.cliente(dadosClienteDTO)
				.build();
		
	}

}
