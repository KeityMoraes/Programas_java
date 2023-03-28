
public class Funcionario {
	private String nome;
	private String numeroDocumento;
	private TipoDeDocumento documento;
	
	public Funcionario(String nome, String numeroDocumento, TipoDeDocumento documento) {
		
		this.nome = nome;
		this.numeroDocumento = numeroDocumento;
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDeDocumento getDocumento() {
		return documento;
	}

	public void setDocumento(TipoDeDocumento documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", numeroDocumento=" + numeroDocumento + ", documento=" + documento + "]";
	}
	
	
}
