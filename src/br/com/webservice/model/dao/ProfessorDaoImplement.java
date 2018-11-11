package br.com.webservice.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.webservice.interfaces.IProfessorDaoInterface;
import br.com.webservice.model.model.ProfessorModel;

public class ProfessorDaoImplement implements IProfessorDaoInterface{
	//aqui está toda o acesso ao banco -- DAO
	@PersistenceContext(unitName = "Projeto4FinalPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public ProfessorModel salvarProfessor(ProfessorModel professorModel) {
		entityManager.persist(professorModel);//salva
		return professorModel;
	}

	@Override
	public void alterar(ProfessorModel professorModel) {						//fundir,misturar
		ProfessorModel professorModelMerge = entityManager.merge(professorModel);//encontra?atualiza
		entityManager.persist(professorModelMerge);
	}

	@Override
	public void excluir(ProfessorModel professsorModel) {
		ProfessorModel professorModelMerge = entityManager.merge(professsorModel);//Precisa msm?
		entityManager.remove(professorModelMerge);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ProfessorModel> getProfessores() {						//referecnia a classe onde
		Query query = entityManager.createQuery("from ProfessorModel");// o hibernate acha a tabela		
		return query.getResultList();
	}

}
