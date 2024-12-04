package sp.senac.qualifier;

import org.springframework.stereotype.Component;

@Component("MySQL")
//@Qualifier("MySQL")
public class MySQL implements Database{

	@Override
	public String getConnection() {
		return "Conectando no servidor MySQL";
	}

}
