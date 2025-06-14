package kleberlz.msavaliadorcredito.exception;

@SuppressWarnings("serial")
public class ErroComunicacaoMicroservicesException extends Exception {
	
	private Integer status;
	
	public ErroComunicacaoMicroservicesException(String msg, Integer status) {
		super(msg);
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
