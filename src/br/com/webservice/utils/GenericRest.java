package br.com.webservice.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

public abstract class GenericRest
{
  protected Response buildResponse(Resposta resposta, HttpServletRequest request)
  {
    return buildResponse(resposta, request, null);
  }
  
  protected Response buildResponse(Resposta resposta, HttpServletRequest request, Map<String, String> headers)
  {
    Response.ResponseBuilder builder = Response.ok(resposta);
    builder.header("Cache-Control", "private, max-age=0, no-cache");
    return builder.build();
  }
  
  protected void preencheRespostaErro(Resposta resposta, Throwable e)
  {
    resposta.setCodigoRetorno("-1");
    
    resposta.setMensagem(e.getMessage());
  }
}