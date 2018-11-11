package br.com.webservice.model.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.webservice.interfaces.ICursoDaoInterface;
import br.com.webservice.interfaces.ICursoServiceInterface;
import br.com.webservice.model.model.CursoModel;

public class CursoService implements ICursoServiceInterface {

	@Inject
	ICursoDaoInterface iCursoDaoInterface;

	@Override
	@Transactional
	public CursoModel salvarCurso(CursoModel cursoModel) {
		return iCursoDaoInterface.salvarCurso(cursoModel);
	}

	@Override
	@Transactional
	public void alterar(CursoModel cursoModel) {
		iCursoDaoInterface.alterar(cursoModel);

	}

	@Override
	@Transactional
	public void excluir(CursoModel cursoModel) {
		iCursoDaoInterface.excluir(cursoModel);
	}

	@Override
	public List<CursoModel> getCursos() {
		return iCursoDaoInterface.getCursos();
	}

}
