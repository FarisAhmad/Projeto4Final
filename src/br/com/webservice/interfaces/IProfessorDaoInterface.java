package br.com.webservice.interfaces;

import java.util.List;

import br.com.webservice.model.model.ProfessorModel;

//defini os métodos a serem criados p manusear o Professor
public interface IProfessorDaoInterface { 
	ProfessorModel salvarProfessor(ProfessorModel professorModel);
	
	void alterar(ProfessorModel professorModel);
	
	void excluir(ProfessorModel professsorModel);
	
	List<ProfessorModel> getProfessores();
}
