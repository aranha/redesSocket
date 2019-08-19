import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

public class TCPClient {
    public static void main(String args []) throws IOException {
        File file = new File("test.txt");

        byte[] sentence = new byte[1024];
        String modifiedSentence;

        Socket clientSocket = new Socket("localhost", 6790);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = Files.readAllBytes(file.toPath());
        outToServer.writeBytes(String.valueOf(sentence));
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}
