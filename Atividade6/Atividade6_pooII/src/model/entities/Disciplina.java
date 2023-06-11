package model.entities;

import java.util.Objects;

public class Disciplina {

	private Integer idDisciplina;
	private String nomeDisciplina;
	private Integer cargahoraria;
	
	public Disciplina() {
		
	}
	
	public Disciplina(Integer idDisciplina, String nomeDisciplina, Integer cargahoraria) {
		this.idDisciplina = idDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.cargahoraria = cargahoraria;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	@Override
	public String toString() {
		return "Disciplina [idDisciplina=" + idDisciplina + ", nomeDisciplina=" + nomeDisciplina + ", cargahoraria="
				+ cargahoraria + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cargahoraria, idDisciplina, nomeDisciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(cargahoraria, other.cargahoraria) && Objects.equals(idDisciplina, other.idDisciplina)
				&& Objects.equals(nomeDisciplina, other.nomeDisciplina);
	}

	public Integer getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(Integer cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

}