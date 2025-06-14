package kleberlz.msavaliadorcredito.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kleberlz.msavaliadorcredito.model.CartaoClienteDTO;
import kleberlz.msavaliadorcredito.model.CartaoDTO;


@FeignClient(name = "mscartoes", path = "/cartoes")
public interface CartoesResourceClient {
	
	@GetMapping("/cpf/{cpf}")
	List<CartaoClienteDTO> buscarCartoesPorCliente(@PathVariable("cpf") String cpf);
	
	@GetMapping("/renda/{renda}")
	List<CartaoDTO> buscarCartoesRendaAte(@PathVariable("renda") Long renda);

}
