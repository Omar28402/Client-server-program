
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server {

    public static void main(String[] args) throws IOException {
       
        ServerSocket serverSocket = new ServerSocket(8008) ; //port number = 5678(start feom 1024)
    
        //server stop waiting for client to connect
        Socket socket =serverSocket.accept();
        
        //take input from client
        Scanner  fromClient = new Scanner(socket.getInputStream());
         
        //input from server
        PrintWriter fromServer = new PrintWriter(socket.getOutputStream());
        
        //to take input from server
        Scanner fromConsole = new Scanner(System.in);
        
        
        
        String inputFormServer , inputFromConsole;
        while (true){
            
            //take input from client and print it to server
           inputFormServer = fromClient.nextLine();
            System.out.println("client : "+inputFormServer);
            
            //check if client close the connection
             if (inputFormServer.equals("*exit*")){
                 break;
             }
            
            System.out.print("server : ");
           inputFromConsole =   fromConsole.nextLine();
            
           
            fromServer.println(inputFromConsole);
            fromServer.flush();//to send the input the client sent B. the printwriter use flush
            
            if (inputFromConsole.equals("*exit*")){
                 break;
             }
        }
    
        socket.close();
    
    
    }
    
}
