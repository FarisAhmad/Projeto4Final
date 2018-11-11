package br.com.webservice.model.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement // indica que precisa gerar um xml para essa classe
@Entity // é um entidade, vai represnetar uma tabela no Banco de dados
@Table(name = "professor")
public class ProfessorModel implements Serializable {// ()Sempre q for
														// transferir dados pela
														// web

	private static final long serialVersionUID = 1L; // oq é isso?

	// indica a chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prof_codigo")
	Long codigo;

	@Column(name = "prof_nome", length = 50, nullable = false)
	String nome;

	@Column(name = "prof_email", length = 50, nullable = true)
	String email;

	@Column(name = "prof_fone", length = 15, nullable = false)
	String fone;
	// duvida?
	// Relacionamento falando q 1 prof tem vários cursos,list
	@OneToMany(mappedBy = "professorModel")
	private List<CursoModel> cursosModel;

	// Retorna uma lista com todos os cursos q esse professor tem
	@XmlTransient
	public List<CursoModel> getCursos() {
		return cursosModel;
	}

	// Pra QND inicializar a pagina n tentar pegar essa lsta de Cursos
	// public List<CursoModel> getCursosModel() {
	// return cursosModel;
	// }

	public void setCursosModel(List<CursoModel> cursosModel) {
		this.cursosModel = cursosModel;
	}

	public ProfessorModel() {

	}

	public ProfessorModel(Long codigo, String nome, String email, String fone) {

		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}

	@Override
	public String toString() {
		return "ProfessorModel [codigo=" + codigo + ", nome=" + nome + ", email=" + email + ", fone=" + fone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfessorModel other = (ProfessorModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	// GETTER AND SETTERS
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigoProfessor) {
		this.codigo = codigoProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

}
