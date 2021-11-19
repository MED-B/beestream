package eddited_package;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class UpdateMessages extends Thread{
    ClientApp app;
    Client client;

    public UpdateMessages(ClientApp app,Client client){
        this.app=app;
        this.client=client;

    }

    public void run(){

        while(client.getSocket().isConnected()){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(client.getMessages().size()!=0){
            //display messages
           app.champMessages.setText(null);
           for(int i=0;i<client.getMessages().size();i++){
               app.champMessages.append(client.getMessages().get(i)+"\n");
           }
           }
        }


    }
}
