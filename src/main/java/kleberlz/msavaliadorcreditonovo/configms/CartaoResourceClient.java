package kleberlz.msavaliadorcreditonovo.configms;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kleberlz.msavaliadorcreditonovo.dto.CartaoDTO;
import kleberlz.msavaliadorcreditonovo.response.CartaoResponseDTO;



@FeignClient(name = "mscartoes", path = "/cartoes")
public interface CartaoResourceClient {
	
	@GetMapping("/cpf/{cpf}")
	List<CartaoResponseDTO> listarCartoesByCpf(@PathVariable String cpf);
	
	@GetMapping("/renda/{renda}")
	List<CartaoDTO> buscarCartoesRendaAte(@PathVariable BigDecimal renda);

}
