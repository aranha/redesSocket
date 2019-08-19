import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String args []) throws IOException {
        String clientSentence;
        ServerSocket welcomeSocket = new ServerSocket(6790);

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            clientSentence = connectionSocket.getOutputStream().toString();
            System.out.println("Received: " + clientSentence);
        }
    }
}
