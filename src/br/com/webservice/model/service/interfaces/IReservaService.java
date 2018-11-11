package br.com.webservice.model.service.interfaces;

import br.com.webservice.model.model.Reserva;
import br.com.webservice.utils.Resposta;

public interface IReservaService {
	Resposta solicitarReserva(Reserva reserva);
	Resposta listarReservas();
}
