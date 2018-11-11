package br.com.webservice.interfaces;

import java.util.List;

import br.com.webservice.model.model.ProfessorModel;

public interface IProfessorServiceInterface {
	ProfessorModel salvarProfessor(ProfessorModel professorModel);
	
	void alterar(ProfessorModel professorModel);
	
	void excluir(ProfessorModel professsorModel);
	
	List<ProfessorModel> getProfessores();
}
