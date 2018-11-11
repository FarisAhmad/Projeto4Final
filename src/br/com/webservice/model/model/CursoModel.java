package br.com.webservice.model.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="curso")
public class CursoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cur_codigo")
	Long codigo;
	
	@Column(name="cur_nome", length=50, nullable = false)
	String nome;
	
	@Column(name="cur_diashorarios", length=50, nullable = true)
	String diasHorarios;
	
	//n cursos 1 professor,1 prf pode está em vários cursos,1 curso somente um 1 prof
	@ManyToOne
	@JoinColumn(name="cur_prof_codigo", foreignKey =@ForeignKey(name="fk_prof_cur") ,referencedColumnName="prof_codigo")//pra trazer a coluna , nomeia, e referecnia
	ProfessorModel professorModel;

	public CursoModel() {

	}

	public CursoModel(Long codigo, String nome, String diasHorarios, ProfessorModel professorModel) {
		this.codigo = codigo;
		this.nome = nome;
		this.diasHorarios = diasHorarios;
		this.professorModel = professorModel;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDiasHorarios() {
		return diasHorarios;
	}

	public void setDiasHorarios(String diasHorarios) {
		this.diasHorarios = diasHorarios;
	}

	public ProfessorModel getProfessorModel() {
		return professorModel;
	}

	public void setProfessorModel(ProfessorModel professorModel) {
		this.professorModel = professorModel;
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
		CursoModel other = (CursoModel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
