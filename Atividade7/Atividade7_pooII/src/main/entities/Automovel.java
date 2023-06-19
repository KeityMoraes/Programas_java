package main.entities;

import java.util.Objects;

public class Automovel {
	private int id;
	private int anoFabricacao;
	private int anoModelo;
	private String observacoes;
	private float preco;
	private int kilometragem;
	private int modelo_id;
	
	public Automovel(int id, int anoFabricacao, int anoModelo, String observacoes, float preco, int kilometragem,
			int modelo_id) {
		this.id = id;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.observacoes = observacoes;
		this.preco = preco;
		this.kilometragem = kilometragem;
		this.modelo_id = modelo_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(int kilometragem) {
		this.kilometragem = kilometragem;
	}

	

	public int getModelo_id() {
		return modelo_id;
	}

	public void setModelo_id(int modelo_id) {
		this.modelo_id = modelo_id;
	}

	@Override
	public String toString() {
		return "Automovel [id=" + id + ", anoFabricacao=" + anoFabricacao + ", anoModelo=" + anoModelo
				+ ", observacoes=" + observacoes + ", preco=" + preco + ", kilometragem=" + kilometragem
				+ ", modelo_id=" + modelo_id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoFabricacao, anoModelo, id, kilometragem, modelo_id, observacoes, preco);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automovel other = (Automovel) obj;
		return anoFabricacao == other.anoFabricacao && anoModelo == other.anoModelo && id == other.id
				&& kilometragem == other.kilometragem && modelo_id == other.modelo_id
				&& Objects.equals(observacoes, other.observacoes)
				&& Float.floatToIntBits(preco) == Float.floatToIntBits(other.preco);
	}
	
	
	
}
