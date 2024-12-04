package sp.senac.component;

import org.springframework.stereotype.Component;

import sp.senac.qualifier.Database;

@Component("MySQLFora")
//@Qualifier("MySQL")
public class MySQLFora implements Database{

	@Override
	public String getConnection() {
		return "Conectando no servidor MySQL";
	}

}
