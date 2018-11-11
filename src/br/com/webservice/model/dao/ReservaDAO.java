package br.com.webservice.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.webservice.model.dao.interfaces.IReservaDAO;
import br.com.webservice.model.model.Reserva;
import br.com.webservice.model.model.Usuario;

public class ReservaDAO implements IReservaDAO{
	
	public List<Reserva> initReservas(){
		Usuario everton = new Usuario(1L,"Everton Minosso","evertoMinosso@gmail.com","61983273312");
		Usuario marcos = new Usuario(2L,"Marcos","marcos@gmail.com","61936184437");
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(new Reserva(1L,"13/11/2018",1,everton));
		reservas.add(new Reserva(2L,"13/11/2018",2,everton));
		reservas.add(new Reserva(3L,"13/11/2018",3,marcos));
		reservas.add(new Reserva(4L,"13/11/2018",4,marcos));
		
		return reservas;
	}

	@Override
	public List<Reserva> recuperarReservas() {
		
		return initReservas();
	}

	@Override
	public List<Reserva> cadastrarSolicitacaoDeReserva(Reserva reserva) {
		List<Reserva> reservas = initReservas();
		reservas.add(reserva);
		return reservas;
	}



}
