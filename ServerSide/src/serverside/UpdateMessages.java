package serverside;

import javax.swing.*;

public class UpdateMessages extends Thread{
    JTextArea champMessages;
    private static boolean stopRequested=false;

    UpdateMessages(JTextArea champMessages){
        this.champMessages=champMessages;
    }

    public synchronized   void requestStop(){
        this.stopRequested=true;
    }
    public synchronized boolean isStopRequested(){
        return this.stopRequested;
    }
    public void run(){
        while(!isStopRequested()){
            try {
                sleep(500);
                       champMessages.setText(null);
                    for(int i=0 ; i<Serveur.getMessages().size();i++){
                        champMessages.append(Serveur.getMessages().get(i)+"\n");
                    }




            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
