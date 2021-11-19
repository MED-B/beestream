package first_edition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MoteurClientApp implements ActionListener {
	ClientApp parent;
	private String username;
	private String ip;
	private int port;
	private Client client;

	NumberFormat formatNombres = NumberFormat.getInstance();

	public MoteurClientApp(ClientApp parent, String username, String ip, int port) {
		this.parent = parent;
		this.username = username;
		this.ip = ip;
		this.port = port;
		client= new Client(this.getIp(), this.getPort(),parent);
		client.setName(username);
		client.start();
	}

	public void actionPerformed(ActionEvent evenement) {

		String textChampEcriture = parent.champEcriture2.getText();
		String textChampAffichage = parent.champAffichage.getText();

		Object sourceEvenement = evenement.getSource();

		if (sourceEvenement == parent.champEcriture2) {

			client.sendMessage(username + " : " + textChampEcriture);
			System.out.println("message sent from client to server");
			parent.champEcriture2.setText(null);

		}
		

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	

}
