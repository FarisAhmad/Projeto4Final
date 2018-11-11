package br.com.webservice.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.webservice.interfaces.IProfessorDaoInterface;
import br.com.webservice.interfaces.IProfessorServiceInterface;
import br.com.webservice.model.model.ProfessorModel;

public class ProfessorServiceImplement implements IProfessorServiceInterface {
	// Só para ter um servico pra o Facede n ter acesso direto ao banco pelo DAO
	// Injeta uma interface e traz todas as classe necessárias pra realizar os
	// metodos da interface

	@Inject
	IProfessorDaoInterface iProfessorDaoInterface;

	@Override
	public List<ProfessorModel> getProfessores() {
		return iProfessorDaoInterface.getProfessores();
	}

	@Override
	@Transactional // transação?
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		return iProfessorDaoInterface.salvarProfessor(professorModel);
	}

	@Override
	@Transactional
	public void alterar(ProfessorModel professorModel) {
		iProfessorDaoInterface.alterar(professorModel);
	}

	@Override
	@Transactional
	public void excluir(ProfessorModel professsorModel) {
		iProfessorDaoInterface.excluir(professsorModel);
	}

}
