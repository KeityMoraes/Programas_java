import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Projeto p1 = new Projeto("Construção da pracinha", df.parse("10/02/2001"), df.parse("10/02/2002"));
		Funcionario f1 = new Funcionario("keity", "1", TipoDeDocumento.CPF);
		Funcionario f2 = new Funcionario("Eliane","2", TipoDeDocumento.RG);
		
		Contratacao c1 = new Contratacao(Cargo.ADMINISTRADOR, f1);
		Contratacao c2 = new Contratacao(Cargo.ANALISTA, f2);
		
		p1.adicionarContratacao(c1);
		p1.adicionarContratacao(c2);
		
		p1.ListarContratacao();
		c1.contratar();
		
		System.out.println("------------------------------------------");
		p1.removerContratacao(c2);
		p1.ListarContratacao();
		
		
	}

}
