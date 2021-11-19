package edditedPackage;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MoteurServerApp implements ActionListener{
ServerApp parent;
NumberFormat formatNombres = NumberFormat.getInstance();



MoteurServerApp(ServerApp parent){
	this.parent=parent;
}
	@Override
	public void actionPerformed(ActionEvent evenement) {
	String text = parent.champEcriture.getText();
		Object sourceEvenement = evenement.getSource();


        if(sourceEvenement == parent.btnStart){
        	// when clicked on btnstart
			System.out.println("server starting...");
			parent.getServer().start();
			(new UpdateMessages(parent,parent.getServer())).start();
System.out.println("server started");
			parent.btnStop.setEnabled(true);
			parent.btnStart.setEnabled(false);
			parent.champEcriture.setEnabled(true);

		}else{
        	if(sourceEvenement == parent.btnStop){
            // when clicked on btnstop
				//stop all threads
				System.out.println("server stopping...");
				parent.getServer().closeServerSocket();

				System.out.println("server stopped "+ parent.getServer().isAlive());
				parent.btnStop.setEnabled(false);
				parent.btnStart.setEnabled(true);
				parent.champEcriture.setEnabled(false);

			}else{
        		if(sourceEvenement == parent.champEcriture){
                  // when clicked on textfield
					parent.getServer().saidTheServer(text);
					parent.champEcriture.setText(null);

				}
			}
		}


		
	}

}
