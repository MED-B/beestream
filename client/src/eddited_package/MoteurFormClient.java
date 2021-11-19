package eddited_package;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class MoteurFormClient implements ActionListener{
FormClient parent;
NumberFormat formatNombres = NumberFormat.getInstance();
public void closeForm() {
	WindowEvent windowEvent = new WindowEvent(parent.frame,WindowEvent.WINDOW_CLOSING);
	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowEvent);
}
public MoteurFormClient(FormClient parent) {
	this.parent=parent;
}
	@Override
	public void actionPerformed(ActionEvent evenement) {
		//TODO get number from port then open clienapp with those params and close this one
		Object sourceEvenement = evenement.getSource();
		String portTF= parent.text3.getText();
		String username =parent.text1.getText();
		String ip = parent.text2.getText();
		double port=5050;
		//get number from port textfield
		if (!"".equals(portTF)) {
			port =
					// analyse la chaîne de caractères
					formatNombres.parse(portTF, new ParsePosition(0) /* ne sert pas */).
					// puis donne sa valeur en tant que double
							doubleValue();
		}
		//open clientapp when click the button
		if(sourceEvenement==parent.boutonOK) {
            if(ip != null && username != null && !username.equalsIgnoreCase("Server")) {

				//close this one
				//this.closeForm();
				//open clientapp with constructor
				try {
					System.out.println("ip : "+ip);
					System.out.println("port : "+(int)port);
					Socket socket = new Socket(ip, (int) port);
					Client client = new Client(socket, username);
					ClientApp clientApp = new ClientApp(client);
					clientApp.frame.setVisible(true);
					parent.frame.setVisible(false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			
		}
	}

}
