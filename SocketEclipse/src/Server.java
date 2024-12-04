import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws IOException {
	// Configurando o servidor
	ServerSocket server = new ServerSocket(4000);
	Socket socket = server.accept();
	System.out.println("Cliente conectou");
	//ler a informa��o
	InputStreamReader inputReader = new InputStreamReader(socket.getInputStream());
	BufferedReader reader = new BufferedReader(inputReader);
	String x;
	while((x = reader.readLine()) != null) {
		System.out.println("Servidor: " + x);
	}
}
}
