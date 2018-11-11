package br.com.webservice.bo;

import java.util.List;

import br.com.webservice.model.dao.ReservaDAO;
import br.com.webservice.model.model.Reserva;
import br.com.webservice.utils.Resposta;

public class ReservaBO extends BOImpl {

	public static Resposta listarReservas() {
		Resposta resposta = new Resposta();
		ReservaDAO dao = new ReservaDAO();

		try {
			List<Reserva> reservas = dao.recuperarReservas();
			resposta.setResultado(reservas);
			return preencheRetornoOK(resposta, "Lista de Reservas");
		} catch (Exception e) {
			return preencheRetornoERRO(resposta, "Error ao recuperar Lista");
		}

	}

	public static Resposta solicitarReserva(Reserva reserva) {
		Resposta resposta = new Resposta();
		ReservaDAO dao = new ReservaDAO();
		try {
			List<Reserva> reservas = dao.cadastrarSolicitacaoDeReserva(reserva);
			for (int i = 0; i < reservas.size(); i++) {
				if(reserva.getData().equals(reservas.get(i).getData()) && reserva.getIdMesa()==reservas.get(i).getIdMesa()){
					return preencheRetornoERRO(resposta, "Mesa já reservada nessa data");
				}
			}
			resposta.setResultado(reservas);
			return preencheRetornoOK(resposta, "Solicitção de reserva feita com sucesso.Por favor agurade o contato de um de nosso atendentes pra confirmação da reserva");
		} catch (Exception e) {
			e.printStackTrace();
			return preencheRetornoERRO(resposta, "Error ao cadastrar reserva");
		}

	}
}
