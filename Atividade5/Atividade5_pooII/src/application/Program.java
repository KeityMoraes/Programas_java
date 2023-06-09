package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import jdbc.AlunoJDBC;


public class Program {

	public static void main(String[] args) {
		
		try {
        	
            int opcao = 0;
            Scanner console = new Scanner(System.in);
            
            do {
            	System.out.println("####### Menu #######"
            						+ "\n1 - Cadastrar"
            						+ "\n2 - Listar"
            						+ "\n3 - Alterar"
            						+ "\n4 - Excluir"
            						+ "\n5 - Sair");
            	System.out.println("\n\tOpção:");
            	opcao = Integer.parseInt(console.nextLine());
            	
            	if (opcao == 1) {
            	
            		Aluno a = new Aluno();
            		AlunoJDBC acao = new AlunoJDBC();
            		
            		System.out.println("\n ### Cadastrar Aluno ### \n\r");
            		
            		System.out.print("Nome: ");
            		a.setNome(console.nextLine());
            		
            		System.out.print("Sexo: ");
            		a.setSexo(console.nextLine());
            	
            		System.out.print("Data de Nascimento (dd-mm-aaaa): ");
 
            		String input = console.nextLine();

            		if (input.matches("\\d{1}-\\d{2}-\\d{4}")) {
            		    input = String.format("0%s", input);
            		}

            		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            		a.setDt_nasc(LocalDate.parse(input, formato));

            		
            		acao.salvar(a);
            		console.nextLine();
            		System.out.println("\n\n\n\n");
            		
            	} else if (opcao == 2) {
            		
            		System.out.println("\n ### Listar Alunos ### \n\r");
            		AlunoJDBC acao = new AlunoJDBC();
            		
            		List<Aluno> alunos = acao.listar();
            		
            		for(Aluno aluno : alunos) {
            			System.out.println("ID: " + aluno.getId());
            			System.out.println("Nome: " + aluno.getNome());
            			System.out.println("Sexo: " + aluno.getSexo());
            			System.out.println("Data de Nascimento: " + aluno.getDt_nasc());
            			System.out.println("\n");
            		}
            		
            		console.nextLine();
            		System.out.println("\n\n\n\n");
            		
            	} else if (opcao == 3) {
            	    
            	    System.out.println("\n ### Alterar Aluno ### \n\r");
            	    AlunoJDBC acao = new AlunoJDBC();
            	    
            	    System.out.print("Informe o ID do aluno que deseja alterar: ");
            	    int id = Integer.parseInt(console.nextLine());
            	    
            	    Aluno aluno = acao.buscarPorId(id);
            	    
            	    if(aluno == null) {
            	        System.out.println("Aluno não encontrado.");
            	    } else {
            	        System.out.println("Aluno encontrado:");
            	        System.out.println("ID: " + aluno.getId());
            	        System.out.println("Nome: " + aluno.getNome());
            	        System.out.println("Sexo: " + aluno.getSexo());
            	        System.out.println("Data de Nascimento: " + aluno.getDt_nasc());
            	        System.out.println("\n");
            	        
            	        System.out.print("Informe o novo nome do aluno (ou enter para manter o mesmo nome): ");
            	        String nome = console.nextLine();
            	        if(!nome.isEmpty()) {
            	            aluno.setNome(nome);
            	        }
            	        
            	        System.out.print("Informe o novo sexo do aluno (ou enter para manter o mesmo sexo): ");
            	        String sexo = console.nextLine();
            	        if(!sexo.isEmpty()) {
            	            aluno.setSexo(sexo);
            	        }
            	        
            	        System.out.print("Informe a nova data de nascimento do aluno (ou enter para manter a mesma data): ");
            	        String data = console.nextLine();
            	        if(!data.isEmpty()) {
            	            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            	            LocalDate dt_nasc = LocalDate.parse(data, formato);
            	            aluno.setDt_nasc(dt_nasc);
            	        }
            	        
            	        acao.atualizar(aluno);
            	        System.out.println("Aluno atualizado com sucesso.");
            	    }
            	    
            	    console.nextLine();
            	    System.out.println("\n\n\n\n");
            	}
            	
            }
            
            while(opcao != 5);
            
        } catch (Exception e){
            System.out.println("Erro: " + e);
        }
	} 
}