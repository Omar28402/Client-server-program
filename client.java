import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        String message, inFromServer;
        
        Socket clientSocket = new Socket("localhost", 8008); //ip 127.0.01 or localhot for machine and port for server
        System.out.println("Establishing connection....");
        
        Scanner inputFromUser = new Scanner(System.in);
        PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(),true);
        Scanner inputFromServer = new Scanner(clientSocket.getInputStream());
        while(true){
            System.out.print("Client: ");
            message = inputFromUser.nextLine();
            
            outputToServer.println(message);
            if(message.equals("**close**"))
                break;
            
            inFromServer = inputFromServer.nextLine();
            System.out.println("Server: "+inFromServer);
        }
        clientSocket.close();
    }
}
