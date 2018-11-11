package br.com.webservice.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.webservice.interfaces.ICursoDaoInterface;
import br.com.webservice.model.model.CursoModel;

public class CursoDao implements ICursoDaoInterface{

	@PersistenceContext(unitName="Projeto4FinalPersistenceUnit")
	private EntityManager entityManager;
	
	@Override
	public CursoModel salvarCurso(CursoModel cursoModel) {
		try {
			entityManager.persist(cursoModel);
			return cursoModel;
		} catch (NullPointerException e) {
			return null;
		}
		
	}

	@Override
	public void alterar(CursoModel cursoModel) {
		CursoModel cursoModelMerge = entityManager.merge(cursoModel);
		entityManager.persist(cursoModelMerge);
	}

	@Override
	public void excluir(CursoModel cursoModel) {
		CursoModel cursoModelMerge = entityManager.merge(cursoModel);
		entityManager.remove(cursoModelMerge);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CursoModel> getCursos() {
		Query query = entityManager.createQuery("from CursoModel");
		return query.getResultList();
	}

}
