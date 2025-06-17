package kleberlz.msavaliadorcreditonovo.configmq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kleberlz.msavaliadorcreditonovo.modelmq.DadosSolicitacaoEmissaoCartao;

@Component
public class SolicitacaoEmissaoCartaoPublisher {
	
	private final RabbitTemplate rabbitTemplate;
	private final Queue queueEmissaoCartoes;
	
	public SolicitacaoEmissaoCartaoPublisher(RabbitTemplate rabbitTemplate, Queue queueEmissaoCartoes) {
		this.rabbitTemplate = rabbitTemplate;
		this.queueEmissaoCartoes = queueEmissaoCartoes;
	}
	
	public void solicitarCartao(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException {//AMQ manda  mensagem String, tem que converter pra JSON.
		var json = convertIntoJson(dados);
		rabbitTemplate.convertAndSend(queueEmissaoCartoes.getName(), json);
	}
	
	private String convertIntoJson(DadosSolicitacaoEmissaoCartao dados) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		var json = mapper.writeValueAsString(dados);
		return json;
	}

}
