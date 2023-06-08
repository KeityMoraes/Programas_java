import java.util.Date;

public class Contratacao {
	private Date datal;
	private Cargo cargo;
	private Status status;
	private Funcionario funcionario;
	
	public Contratacao(Cargo cargo, Funcionario f) {
		
		this.datal = new Date();
		this.cargo = cargo;
		this.status = Status.PENDENTE;
		this.funcionario = f;
	}
	
	public void pendente() {
		this.status = Status.PENDENTE;
		
	}
	
	public void contratar() {
		this.status = Status.CONTRATADO;
	}
	
	public void demitir() {
		this.status = Status.DEMITIDO;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Date getDatal() {
		return datal;
	}

	public Status getStatus() {
		return status;
	}
	
	

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Contratacao [data=" + datal + ", cargo=" + cargo + ", status=" + status + ", funcionario="
				+ funcionario + "]";
	}
	
	
	
	
}
