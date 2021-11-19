package eddited_package;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MoteurClientApp implements ActionListener {
	ClientApp parent;
	NumberFormat formatNombres = NumberFormat.getInstance();

	public MoteurClientApp(ClientApp parent) {
		this.parent = parent;
	}

	public void actionPerformed(ActionEvent evenement) {

		String textChampEcriture = parent.champEcriture2.getText();
		String textChampAffichage = parent.champAffichage.getText();

		Object sourceEvenement = evenement.getSource();

		if (sourceEvenement == parent.champEcriture2) {

			parent.getClient().sendClientMessage(textChampEcriture);
			System.out.println("message sent from client to server");
			parent.champEcriture2.setText(null);

		}
		

	}

	

}
