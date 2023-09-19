package br.com.catalisa.registroAlunos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Registro Alunos", version = "1", description = "API para registro de alunos de uma escola com foco em utilizar nomes sociais de alunos transgênero de maneira mais humanizada"))
public class RegistroAlunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroAlunosApplication.class, args);
	}

}
