package br.com.webservice.model.service;

import br.com.webservice.bo.ReservaBO;
import br.com.webservice.model.model.Reserva;
import br.com.webservice.model.service.interfaces.IReservaService;
import br.com.webservice.utils.Resposta;

public class ReservaService implements IReservaService {
	//private ReservaBO reservaBO;

	public Resposta solicitarReserva(Reserva reserva) {
		return ReservaBO.solicitarReserva(reserva);
	}
	
	public Resposta listarReservas() {
		return ReservaBO.listarReservas();
	}
	
	
	

}
