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

import br.com.webservice.interfaces.IProfessorServiceInterface;
import br.com.webservice.model.model.ProfessorModel;

@Path("/professores")//indica o caminho para ser pego pelo rest

//para devolver oq se pede ao server,browser espera um text e mandamos um array list PRODUCES
//Indica o tipo que estamos produzimos
@Produces({MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML})   

//Indica o tipo que será consumido
@Consumes(MediaType.APPLICATION_JSON)

public class ProfessorFacade {
	
	
	//null poniter Exception, se n inicializar o inject
	//direto, sem o uso do serviço, acessa deireto o banco pelo DAO
//	@Inject 
//	private ProfessorDaoImplement professorDaoImplement;
//	
//	@GET
//	public List<ProfessorModel> getProfessores(){
//		return professorDaoImplement.getProfessores();
//	}
	
	//Mesma ideia, injeta a inerface e traz todas as classes  para os métodos funcinarem
	//o Inject q faz isso!
	@Inject
	private IProfessorServiceInterface iProfessorServiceInterface;
	
	@GET
	public List<ProfessorModel> getProfessores(){
		return iProfessorServiceInterface.getProfessores();
	}
	
	@POST
	public ProfessorModel salvarProfessor(ProfessorModel professorModel){
		return iProfessorServiceInterface.salvarProfessor(professorModel);
	}
	
	@PUT
	public void atualizar(ProfessorModel professorModel){
		iProfessorServiceInterface.alterar(professorModel);
	}
	
	@DELETE
	@Path("/{codigoProfessor}")
	public void excluir(@PathParam("codigoProfessor") Long codigoProfessor){
		ProfessorModel professorModel = new ProfessorModel();
		professorModel.setCodigo(codigoProfessor);
		iProfessorServiceInterface.excluir(professorModel);
	}
}
