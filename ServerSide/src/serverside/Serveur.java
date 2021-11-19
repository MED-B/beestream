package serverside;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serveur extends Thread{

	public static  List<String> MESSAGES = new ArrayList<String>();
    private static boolean stopAllRequested=false;
    private int port;
    
    
    Serveur(int port){
    	this.port=port;
    }
    
    public synchronized   void requestStop(){
        this.stopAllRequested=true;
    }
    public synchronized boolean isStopAllRequested(){
        return this.stopAllRequested;
    }
    public synchronized static void addToMessages(String message) {
    	MESSAGES.add(message);
    }
    public synchronized static List<String> getMessages(){
        return MESSAGES;
    }


    @Override
    public void run(){

                try{
                    //create socket
                    ServerSocket sersoc =new ServerSocket(port);
                    //new client
                    Socket soc = sersoc.accept();
                    //new server to listen
                    (new Serveur(port)).start();
                    System.out.println("new client");
                    //start listening with created socket
                    while(!isStopAllRequested()){

                        if(isStopAllRequested()){
                            System.out.println("stop requested!");
                        }else{
                            System.out.println("send messages");
                            //sending all messages first
                            OutputStream os = soc.getOutputStream();
                            ObjectOutputStream out = new ObjectOutputStream(os);
                            out.writeObject(getMessages());
                            System.out.println("message send to server");
                            out.reset();
                            //recieving a message from the socket
                            InputStream in = soc.getInputStream();
                            ObjectInputStream entree = new ObjectInputStream(in);
                            if((String) entree.readObject()!=null)
                            addToMessages((String) entree.readObject());
                        }
                    }




                }catch (Exception e ){
                }
    	System.out.println("thread"+Thread.currentThread().getName()+" finished!");
    }


	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
    
}
