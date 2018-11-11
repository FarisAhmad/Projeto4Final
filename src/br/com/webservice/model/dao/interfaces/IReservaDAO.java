package br.com.webservice.model.dao.interfaces;

import java.util.List;

import br.com.webservice.model.model.Reserva;

public interface IReservaDAO {
	List<Reserva> recuperarReservas();
	List<Reserva> cadastrarSolicitacaoDeReserva(Reserva reserva);
}
