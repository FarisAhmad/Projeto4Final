package br.com.webservice.bo;

import br.com.webservice.utils.Resposta;

public abstract class BOImpl {
	protected static Resposta preencheRetornoOK(Resposta resposta, String msg) {
        resposta.setMensagem(msg);
        resposta.setCodigoRetorno("1");

        return resposta;
    }

    protected static Resposta preencheRetornoERRO(Resposta resposta, String msg) {
        resposta.setMensagem(msg);
        resposta.setCodigoRetorno("-1");

        return resposta;
    }


}
