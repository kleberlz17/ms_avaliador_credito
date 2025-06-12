package kleberlz.msavaliadorcredito.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kleberlz.msavaliadorcredito.model.DadosClienteDTO;

@FeignClient(name = "msclientes", path = "/clientes") //Aponta para msclientes e faz requisiçao para /clientes
public interface ClienteResourceClient {
	

	@GetMapping("/cpf/{cpf}")
	DadosClienteDTO dadosCliente(@PathVariable("cpf") String cpf);

}
