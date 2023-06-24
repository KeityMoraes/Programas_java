package br.edu.ifgoias.academico.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.edu.ifgoias.academico.entities.Curso;
import br.edu.ifgoias.academico.repositories.CursoRepository;

@Configuration
public class Config implements CommandLineRunner{

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Curso curso1 = new Curso(null, "Curso teste");
		Curso curso2 = new Curso(null, "Curso teste 2");
	
		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		
	}

}
