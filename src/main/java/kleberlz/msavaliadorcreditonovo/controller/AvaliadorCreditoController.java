package kleberlz.msavaliadorcreditonovo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kleberlz.msavaliadorcreditonovo.dto.AvaliacaoClienteRequestDTO;
import kleberlz.msavaliadorcreditonovo.modelmq.DadosSolicitacaoEmissaoCartao;
import kleberlz.msavaliadorcreditonovo.modelmq.ProtocoloSolicitacaoCartao;
import kleberlz.msavaliadorcreditonovo.response.ResponseAvaliacaoClienteDTO;
import kleberlz.msavaliadorcreditonovo.response.SituacaoClienteResponseDTO;
import kleberlz.msavaliadorcreditonovo.service.AvaliadorCreditoService;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {
	
	private final AvaliadorCreditoService avaliadorCreditoService;
	
	public AvaliadorCreditoController(AvaliadorCreditoService avaliadorCreditoService) {
		this.avaliadorCreditoService = avaliadorCreditoService;
	}
	
	@GetMapping("/situacao/{cpf}")
	public ResponseEntity<SituacaoClienteResponseDTO> obterSituacaoCliente(@PathVariable String cpf) {
		SituacaoClienteResponseDTO response = avaliadorCreditoService.obterSituacaoCliente(cpf);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseAvaliacaoClienteDTO> realizarAvaliacao(@RequestBody @Valid AvaliacaoClienteRequestDTO request) {
		ResponseAvaliacaoClienteDTO response = avaliadorCreditoService.realizarAvaliacao(request.getCpf(), request.getRenda());
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/solicitar-cartao")
	public ResponseEntity<ProtocoloSolicitacaoCartao> solicitarEmissaoCartao(@RequestBody @Valid DadosSolicitacaoEmissaoCartao dados) {
		ProtocoloSolicitacaoCartao response  = avaliadorCreditoService.solicitarEmissaoCartao(dados);
		return ResponseEntity.ok(response);
	}

}
