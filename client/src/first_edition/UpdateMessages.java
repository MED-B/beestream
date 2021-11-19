package first_edition;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class UpdateMessages extends Thread{
    ClientApp app;
    Socket soc;

    private boolean stopRequested = false;
    public UpdateMessages(ClientApp app,Socket soc){
        this.app=app;
        this.soc=soc;

    }
    public synchronized void requestStop() {
        this.stopRequested = true;
    }
    public synchronized boolean isStopRequested() {
        return this.stopRequested;
    }

    public void run(){
        try {

             while(!isStopRequested()){

                sleep(1000);

                // message recu du serveur
                 InputStream is = soc.getInputStream();
                 ObjectInputStream in= new ObjectInputStream(is);
                List<String> messages = (List<String>) in.readObject();

                 //display messages
                app.champMessages.setText(null);
                for(int i=0;i<messages.size();i++){
                    System.out.println("updating messages..");
                    app.champMessages.append(messages.get(i)+"\n");
                }
             }
    } catch (InterruptedException | IOException | ClassNotFoundException e) {
        e.printStackTrace();
        app.champMessages.setText(null);
        app.champMessages.append(e.toString());
    }


    }
}
