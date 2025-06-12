package kleberlz.msavaliadorcredito.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/situacao/{cpf}")
	public ResponseEntity<SituacaoCliente> consultaSituacaoCliente(@PathVariable String cpf) {
		SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
		return ResponseEntity.ok(situacaoCliente);
	}

}
