package sp.senac.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//Comentar essa parte depois do Scope
@ComponentScan("sp.senac.component")
// CommandLineRunner -> para executar no console de comando
public class QualifierApplication implements CommandLineRunner {
	
	@Autowired
	@Qualifier("MySQLFora")
	private Database database;
	
	public static void main(String[] args) {
		SpringApplication.run(QualifierApplication.class, args);
		
	}
// Esse método é do CommandLineRunner
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.database.getConnection());
		
	}

}
