package br.com.webservice.interfaces;

import java.util.List;

import br.com.webservice.model.model.CursoModel;

public interface ICursoDaoInterface{
		
	CursoModel salvarCurso(CursoModel cursoModel);
	
	void alterar(CursoModel cursoModel);
	
	void excluir(CursoModel cursoModel);
	
	List<CursoModel> getCursos();
}
