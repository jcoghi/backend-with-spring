package sp.senac.qualifier;

import org.springframework.stereotype.Component;

@Component("Oracle")
//@Qualifier("Oracle")
public class Oracle implements Database {
	
	@Override
	public String getConnection() {
		return "Conectando no servidor ORACLE";
	}

}
