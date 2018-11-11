package br.com.webservice.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resposta")
public class Resposta {
	public static final String RETORNO_ERRO = "-1";
	public static final String RETORNO_OK = "1";
	private Object resultado;
	private String mensagem;
	private String codigoRetorno;

	public String getMensagem() {
		return this.mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCodigoRetorno() {
		return this.codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public Object getResultado() {
		return this.resultado;
	}

	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}
}
