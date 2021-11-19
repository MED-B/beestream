package serverside;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class MoteurServerApp implements ActionListener{
ServerApp parent;
	UpdateMessages updates;
 double port;
NumberFormat formatNombres = NumberFormat.getInstance();



MoteurServerApp(ServerApp parent,double port){
	this.port=port;
	this.parent=parent;
	updates=new UpdateMessages(parent.champMessages);
	updates.start();
}
	@Override
	public void actionPerformed(ActionEvent evenement) {
	String text = parent.champEcriture.getText();
		Object sourceEvenement = evenement.getSource();
		Serveur srv=new Serveur((int) port);


        if(sourceEvenement == parent.btnStart){
        	// when clicked on btnstart
			srv.start();
            Serveur.addToMessages("Server is listening...");
			parent.btnStop.setEnabled(true);
			parent.btnStart.setEnabled(false);
			parent.champEcriture.setEnabled(true);

		}else{
        	if(sourceEvenement == parent.btnStop){
            // when clicked on btnstop
				//stop all threads
				   srv.requestStop();
				   updates.requestStop();
				Serveur.addToMessages("Server is stopping...");
				if(srv.isAlive()==false && srv.isStopAllRequested() == true)
					Serveur.addToMessages("Server is stopped !");
				parent.btnStop.setEnabled(false);
				parent.btnStart.setEnabled(true);
				parent.champEcriture.setEnabled(false);

			}else{
        		if(sourceEvenement == parent.champEcriture){
                  // when clicked on textfield
					Serveur.addToMessages("Server : "+text);
					parent.champEcriture.setText(null);

				}
			}
		}


		
	}

}
