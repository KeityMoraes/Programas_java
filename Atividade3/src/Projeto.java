import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Projeto {
	private String nome;
	private Date dataInicio;
	private Date dataTermino;
	private List<Contratacao> listaContratacao = new ArrayList<>();
	
	public Projeto(String nome, Date dataInicio, Date dataTermino) {

		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}

	public boolean adicionarContratacao(Contratacao c) {
		if (!this.listaContratacao.contains(c)) {
			this.listaContratacao.add(c);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean removerContratacao(Contratacao c) {
		if (this.listaContratacao.contains(c)) {
			this.listaContratacao.remove(c);
			return true;
		}else {
			return false;
		}
	}
	
	public void ListarContratacao() {
		if (this.listaContratacao.isEmpty()) {
			System.out.println("Sem contratações");
		}else {
			System.out.println("***Contratações***");
			System.out.println("Projeto: " + this.getNome());
			System.out.println("Funcionarios: \n" );
			for(Contratacao c: this.listaContratacao) {
				
				System.out.println(c.getFuncionario().getNome() + "[Status: "+c.getStatus()+"]");
			}
		}
		//implementar
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino
				+ ", listaContratacao=" + listaContratacao + "]";
	}
	
	
	
	

}
