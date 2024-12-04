import java.util.Scanner;

public class Ex01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x1, x2, y1, y2, d;
		String entrada;
		String[] dados = new String[5];
		Scanner tc = new Scanner(System.in);
		
		System.out.println("Insira X e Y do primeiro ponto no formato X,Y");
		entrada = tc.next();
		
		entrada = entrada.split(",");
		
		System.out.println(x1 + "," + y1);
		
		
	}

}
