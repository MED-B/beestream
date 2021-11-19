package edditedPackage;

import javax.swing.*;

public class UpdateMessages extends Thread{
    ServerApp serverApp;
    Server server;

    UpdateMessages(ServerApp serverApp,Server server){
        this.serverApp=serverApp;
        this.server=server;
    }

    public void run(){
        while(!server.getServerSocket().isClosed()){
            try {
                sleep(1000);
                if(Server.getMESSAGES().size()!=0) {
                    serverApp.champMessages.setText(null);
                    for (int i = 0; i < Server.getMESSAGES().size(); i++) {
                        serverApp.champMessages.append(Server.getMESSAGES().get(i) + "\n");
                    }
                }



            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
