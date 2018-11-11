package br.com.webservice.model.rest.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.webservice.interfaces.ICursoServiceInterface;
import br.com.webservice.model.model.CursoModel;

@Path("/cursos")//indica o caminho para ser pego pelo rest

//para devolver oq se pede ao server,browser espera um text e mandamos um array list PRODUCES
//Indica o tipo que estamos produzimos
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})   

//Indica o tipo que será consumido
@Consumes(MediaType.APPLICATION_JSON)

public class CursoFacade {
	
	@Inject
	ICursoServiceInterface iCursoServiceInterface;
	
	@GET
	public List<CursoModel> getCursos(){
		return iCursoServiceInterface.getCursos();
	}
	
	@POST
	public CursoModel salvarCurso(CursoModel cursoModel){
		return iCursoServiceInterface.salvarCurso(cursoModel);
	}
	
	@PUT
	public void alterar(CursoModel cursoModel){
		iCursoServiceInterface.alterar(cursoModel);
	}

	@DELETE
	@Path("/{codigoCurso}")
	public void excluir(@PathParam("codigoCurso") Long codigoCurso){
		CursoModel cursoModel = new CursoModel();
		cursoModel.setCodigo(codigoCurso);
		iCursoServiceInterface.excluir(cursoModel);
	}
}
