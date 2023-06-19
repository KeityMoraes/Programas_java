package main.entities;

import java.util.Objects;

public class Modelo {
	private int id;
	private String descricao;
	private int potencia;
	private int marca_id;
	
	public Modelo(int id, String descricao, int potencia, int marca_id) {
	
		this.id = id;
		this.descricao = descricao;
		this.potencia = potencia;
		this.marca_id = marca_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getMarca_id() {
		return marca_id;
	}

	public void setMarca_id(int marca_id) {
		this.marca_id = marca_id;
	}

	@Override
	public String toString() {
		return "Modelo [id=" + id + ", descricao=" + descricao + ", potencia=" + potencia + ", marca_id=" + marca_id
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, marca_id, potencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		return Objects.equals(descricao, other.descricao) && id == other.id && Objects.equals(marca_id, other.marca_id)
				&& potencia == other.potencia;
	}
	
	
	
}
