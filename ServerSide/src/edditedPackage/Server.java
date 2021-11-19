package edditedPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{
    private final ServerSocket serverSocket;
    private  ClientHandler serverHandler;
    private static List<String> MESSAGES=new ArrayList<String>();

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
public void run(){
    try {
        while (!serverSocket.isClosed()) {
            Socket socket = serverSocket.accept();
               if(serverHandler==null)
                   serverHandler=new ClientHandler(socket);
               else{
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread thread = new Thread(clientHandler);
            thread.start();}
        }
    } catch (IOException e) {
        closeServerSocket();
    }
}


    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saidTheServer(String message) {
        if(!serverSocket.isClosed()){
            if(serverHandler!=null){
                serverHandler.broadcastMessage("Server : "+message);
                Server.getMESSAGES().add(message);
            }

        }

    }


    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public synchronized static List<String> getMESSAGES() {
        return MESSAGES;
    }



}
