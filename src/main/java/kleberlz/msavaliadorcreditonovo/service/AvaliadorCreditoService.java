package kleberlz.msavaliadorcreditonovo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import feign.FeignException;
import kleberlz.msavaliadorcreditonovo.configmq.SolicitacaoEmissaoCartaoPublisher;
import kleberlz.msavaliadorcreditonovo.configms.CartaoResourceClient;
import kleberlz.msavaliadorcreditonovo.configms.ClienteResourceClient;
import kleberlz.msavaliadorcreditonovo.dto.CartaoDTO;
import kleberlz.msavaliadorcreditonovo.dto.ClienteDTO;
import kleberlz.msavaliadorcreditonovo.exception.ErroSolicitacaoCartaoException;
import kleberlz.msavaliadorcreditonovo.mapper.CartaoAprovadoResponseConverter;
import kleberlz.msavaliadorcreditonovo.modelmq.DadosSolicitacaoEmissaoCartao;
import kleberlz.msavaliadorcreditonovo.modelmq.ProtocoloSolicitacaoCartao;
import kleberlz.msavaliadorcreditonovo.response.CartaoResponseDTO;
import kleberlz.msavaliadorcreditonovo.response.ResponseAvaliacaoClienteDTO;
import kleberlz.msavaliadorcreditonovo.response.SituacaoClienteResponseDTO;

@Service
public class AvaliadorCreditoService {
	
	private final ClienteResourceClient clientesClient;
	private final CartaoResourceClient cartoesClient;
	private final CartaoAprovadoResponseConverter cartaoAprovadoResponseConverter;
	private final SolicitacaoEmissaoCartaoPublisher emissaoCartaoPublisher;
	
	public AvaliadorCreditoService(ClienteResourceClient clientesClient, CartaoResourceClient cartoesClient,
			CartaoAprovadoResponseConverter cartaoAprovadoResponseConverter, SolicitacaoEmissaoCartaoPublisher emissaoCartaoPublisher) {
		
		this.clientesClient = clientesClient;
		this.cartoesClient = cartoesClient;
		this.cartaoAprovadoResponseConverter = cartaoAprovadoResponseConverter;
		this.emissaoCartaoPublisher = emissaoCartaoPublisher;
	}
	
	public SituacaoClienteResponseDTO obterSituacaoCliente(String cpf) {
		
		try {
			
			ResponseEntity<ClienteDTO> dadosClienteDTO = clientesClient.buscarPorCpf(cpf);
			List<CartaoResponseDTO> cartoesClienteDTO = cartoesClient.listarCartoesByCpf(cpf);
			
			return SituacaoClienteResponseDTO
					.builder()
					.cliente(dadosClienteDTO.getBody())
					.cartoes(cartoesClienteDTO)
					.build();
			
		} catch (FeignException.FeignClientException ex) {
			if(ex.status() == HttpStatus.NOT_FOUND.value()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
			}
			throw new RuntimeException("Erro ao consultar situação do cliente", ex);	
		}
	}
	
	public ResponseAvaliacaoClienteDTO realizarAvaliacao(String cpf, BigDecimal renda) {
		try {
			
			ResponseEntity<ClienteDTO> dadosClienteDTO = clientesClient.buscarPorCpf(cpf);
			List<CartaoDTO> cartoesDTO = cartoesClient.buscarCartoesRendaAte(renda);
			
			Integer idade = dadosClienteDTO.getBody().getIdade();
			
			var listaCartoesAprovados = cartoesDTO.stream()
					.map(cartao -> cartaoAprovadoResponseConverter.dtoParaDto(cartao, idade))
					.filter(Objects::nonNull)
					.collect(Collectors.toList());
			
			return new ResponseAvaliacaoClienteDTO(listaCartoesAprovados);
			
		} catch (FeignException.FeignClientException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
		}
			
		}
	
	public ProtocoloSolicitacaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dados) {
		try {
			emissaoCartaoPublisher.solicitarCartao(dados);
			var protocolo = UUID.randomUUID().toString();
			return new ProtocoloSolicitacaoCartao(protocolo);
			
		} catch (Exception ex) {
			throw new ErroSolicitacaoCartaoException(ex.getMessage());
			
		}
	}
}
