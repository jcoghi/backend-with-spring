import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
public static void main(String[] args) throws UnknownHostException, IOException {
	Socket socket = new Socket("localhost", 4000);
	Scanner input = new Scanner(System.in);
	
	PrintStream saida = new PrintStream(socket.getOutputStream());
	String teclado = input.nextLine();
	saida.println(teclado);
}
}
