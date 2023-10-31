import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteJava {

    public static void main(String[] args) {
        String serverName = "192.168.0.23";
        int serverPort = 12346;

        try (Socket clientSocket = new Socket(serverName, serverPort);
             PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter (SEND or RECEIVE): ");
            String option = scanner.nextLine();
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();

            outToServer.println(option);
            outToServer.println(fileName);

            if ("SEND".equals(option)) {
                try (FileInputStream fileInputStream = new FileInputStream(fileName);
                     OutputStream fileOutputStream = clientSocket.getOutputStream()) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                    System.out.println("File sent.");
                }
            } else if ("RECEIVE".equals(option)) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                     InputStream fileInputStream = clientSocket.getInputStream()) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                    System.out.println("File received and saved.");
                }
            } else {
                System.out.println("Invalid option: " + option);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
