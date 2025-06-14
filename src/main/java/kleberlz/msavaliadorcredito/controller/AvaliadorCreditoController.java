package kleberlz.msavaliadorcredito.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kleberlz.msavaliadorcredito.exception.DadosClienteNotFoundException;
import kleberlz.msavaliadorcredito.exception.ErroComunicacaoMicroservicesException;
import kleberlz.msavaliadorcredito.model.DadosAvaliacaoDTO;
import kleberlz.msavaliadorcredito.model.RetornoAvaliacaoClienteDTO;
import kleberlz.msavaliadorcredito.model.SituacaoCliente;
import kleberlz.msavaliadorcredito.service.AvaliadorCreditoService;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {
	
	private final AvaliadorCreditoService avaliadorCreditoService;
	
	public AvaliadorCreditoController(AvaliadorCreditoService avaliadorCreditoService) {
		this.avaliadorCreditoService = avaliadorCreditoService;
	}
	
	@GetMapping
	public String status() {
		return "ok";
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/situacao/{cpf}")
	public ResponseEntity consultaSituacaoCliente(@PathVariable String cpf) {
		try {
			SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
			return ResponseEntity.ok(situacaoCliente);
		} catch (DadosClienteNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ErroComunicacaoMicroservicesException e) {
			return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
		}
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacaoDTO dados) {
		try {
			RetornoAvaliacaoClienteDTO retornoAvaliacaoClienteDTO = avaliadorCreditoService
					.realizarAvaliacao(dados.getCpf(), dados.getRenda());
			return ResponseEntity.ok(retornoAvaliacaoClienteDTO);
		} catch (DadosClienteNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (ErroComunicacaoMicroservicesException e) {
			return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
		}
		
	}

}
