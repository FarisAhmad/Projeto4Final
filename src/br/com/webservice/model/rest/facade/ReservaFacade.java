package br.com.webservice.model.rest.facade;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.webservice.model.model.Reserva;
import br.com.webservice.model.service.ReservaService;
import br.com.webservice.model.service.interfaces.IReservaService;
import br.com.webservice.utils.GenericRest;
import br.com.webservice.utils.Resposta;

@Path("/reserva")
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML}) 
@Consumes(MediaType.APPLICATION_JSON)
public class ReservaFacade extends GenericRest{
	@Inject
	private IReservaService reservaService;
	//private ReservaService reservaService;
	
	@POST
	@Path("/solicitarReserva")
	public Resposta solicitarReserva(Reserva reserva){
		//ReservaService reservaService = new ReservaService();
		System.out.println(reserva.getData());
		Resposta resposta = reservaService.solicitarReserva(reserva);
		return resposta;
		
	}
	
	@GET
	@Path("/listarReservas")
	public Resposta listarReserva(){
		//ReservaService reservaService = new ReservaService();
		Resposta resposta = reservaService.listarReservas();
		return resposta;
		
	}

}
