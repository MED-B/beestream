package eddited_package;

import javax.swing.*;
import java.awt.*;

public class ClientApp {
	private Client client;
	

	
	 JFrame frame;
	 JPanel contenuFenetre;
	 JTextArea champMessages;
	 JTextField champAffichage;
	 JTextField champEcriture2;
	 JScrollPane sp;
	 
	 ClientApp(Client client){
		 this.client=client;
		//creations
		 GridBagConstraints contr = new GridBagConstraints();    
		 GridBagLayout disposition = new GridBagLayout();
		 contenuFenetre = new JPanel();
		 contenuFenetre.setLayout(disposition);
		 champAffichage = new JTextField(10);
		 champAffichage.setText(this.client.getUsername());
		 champAffichage.setEnabled(false);
		 champAffichage.setDisabledTextColor(new Color(0, 0, 0));
		 champAffichage.setFont(new Font("Simplified Arabic", Font.PLAIN, 25));
		 
		 champMessages = new JTextArea();
		 champMessages.setEnabled(false);
		 champMessages.setDisabledTextColor(new Color(0, 0, 0));
		 champMessages.setFont(new Font("Simplified Arabic", Font.PLAIN, 25));
		 champMessages.setMaximumSize(new Dimension(500,500));
		 champEcriture2 = new JTextField(10);
		 champEcriture2.setEnabled(true);
		 champEcriture2.setDisabledTextColor(new Color(0, 0, 0));
		 champEcriture2.setFont(new Font("Simplified Arabic", Font.PLAIN, 25));
		
		    
		 
         
		
		//addition de style 
		  //de couleur
		 champAffichage.setBackground(new Color(224, 220, 203));
		 champMessages.setBackground(new Color(246, 243, 223));
		 champEcriture2.setBackground(new Color(253, 252, 244));
		//confeguration
	      
		

		 
		 
		 contr.gridx=0;
		 contr.gridy=0;
		 contr.gridheight=1;
		 contr.gridwidth=5;
		 contr.fill = GridBagConstraints.BOTH;
			// proportion d'espace horizontal occupee par ce composant
			contr.weightx = 5;
			// proportion d'espace vertical occupee par ce composant
			contr.weighty = 1;

			// position du composant dans la cellule
			contr.anchor = GridBagConstraints.CENTER; 
		 contenuFenetre.add(champAffichage,contr);
		 
		 
		 contr.gridx=0;
		 contr.gridy=1;
		 contr.gridheight=3;
		 contr.gridwidth=5;
		 contr.fill = GridBagConstraints.BOTH;
			// proportion d'espace horizontal occupee par ce composant
			contr.weightx = 5;
			// proportion d'espace vertical occupee par ce composant
			contr.weighty = 3;

			// position du composant dans la cellule
			contr.anchor = GridBagConstraints.CENTER; 
		 contenuFenetre.add(champMessages,contr);
		 sp=new JScrollPane(champMessages,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 contenuFenetre.add(sp,contr); 
		 
		 contr.gridx=0;
		 contr.gridy=5;
		 contr.gridheight=1;
		 contr.gridwidth=5;
		 contr.fill = GridBagConstraints.BOTH;
			// proportion d'espace horizontal occupee par ce composant
			contr.weightx = 5;
			// proportion d'espace vertical occupee par ce composant
			contr.weighty = 1;

			// position du composant dans la cellule
			contr.anchor = GridBagConstraints.CENTER; 
		 contenuFenetre.add(champEcriture2,contr);
		 //ajouter un actionlistner
		 MoteurClientApp moteurClientApp = new MoteurClientApp(this);
		 champEcriture2.addActionListener(moteurClientApp);
		 
		//pour le cadre
			
		 frame = new JFrame("JustBee");
		 frame.setContentPane(contenuFenetre);
		 frame.setSize(500,500);
		 frame.setVisible(true);
		 frame.setResizable(false);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 client.start();
		 (new UpdateMessages(this,client)).start();
	 }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
