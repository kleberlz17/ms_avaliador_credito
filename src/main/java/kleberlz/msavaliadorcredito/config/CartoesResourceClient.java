package kleberlz.msavaliadorcredito.config;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kleberlz.msavaliadorcredito.model.CartaoClienteDTO;

@FeignClient(name = "mscartoes", path = "/cartoes")
public interface CartoesResourceClient {
	
	@GetMapping("/cpf/{cpf}")
	List<CartaoClienteDTO> buscarCartoesPorCliente(@PathVariable("cpf") String cpf);

}
