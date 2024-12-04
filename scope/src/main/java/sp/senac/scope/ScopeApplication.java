package sp.senac.scope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ScopeApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(ScopeApplication.class, args);
		
		Pessoa p1 = app.getBean(Pessoa.class);
		Pessoa p2 = app.getBean(Pessoa.class);
		
		System.out.println(p1);
		System.out.println(p2);		
	}

}
