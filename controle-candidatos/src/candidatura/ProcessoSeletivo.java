package candidatura;

import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	
	static String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
	static String[] selecionados = new String[5];
	
	public static void main(String[] args) {
		int a = 0;
		System.out.println("Processo Seletivo");
		
		for(int i = 0; i < candidatos.length; i++) {
			String candidato = analisarCandidato(candidatos[i], valorPretendido());
			if(!(candidato == null) && a < 5) {
				selecionados[a] = candidato;
				a++;
			}
		}
		
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static String analisarCandidato(String candidato, double salarioCandidato) {
		if(2000 > salarioCandidato) {
			System.out.println("LIGAR PARA O CANDIDATO");
			return candidato;
		}
	    else if( 2000 < salarioCandidato) {
	    	System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
	    	return candidato;
	    }
	    else {
	    	System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
	    	return null;
	    }
	}
}
