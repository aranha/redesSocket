import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;

public class UDPClient {
    public static void main(String args[]) throws IOException {
        File file = new File("test.txt");

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress ipAddress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];
        sendData = Files.readAllBytes(file.toPath());

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress, 9876);

        clientSocket.send(sendPacket);

        clientSocket.close();
    }
}
