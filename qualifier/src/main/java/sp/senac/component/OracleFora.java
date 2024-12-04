package sp.senac.component;

import org.springframework.stereotype.Component;

import sp.senac.qualifier.Database;

@Component("OracleFora")
public class OracleFora implements Database {
	
	@Override
	public String getConnection() {
		return "Conectando no servidor ORACLE";
	}

}
