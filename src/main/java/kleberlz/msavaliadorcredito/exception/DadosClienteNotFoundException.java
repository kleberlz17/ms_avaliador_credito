package kleberlz.msavaliadorcredito.exception;

@SuppressWarnings("serial")
public class DadosClienteNotFoundException  extends Exception {
	public DadosClienteNotFoundException() {
		super("Dados do cliente não encontrados para o CPF informado.");
	}

}
