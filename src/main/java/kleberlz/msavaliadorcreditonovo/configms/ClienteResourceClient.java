package kleberlz.msavaliadorcreditonovo.configms;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kleberlz.msavaliadorcreditonovo.dto.ClienteDTO;

@FeignClient(name = "msclientes", path = "/clientes")
public interface ClienteResourceClient {
	
	@GetMapping("/cpf/{cpf}")
	ResponseEntity<ClienteDTO> buscarPorCpf (@PathVariable String cpf);

}
