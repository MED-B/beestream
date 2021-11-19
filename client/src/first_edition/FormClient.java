package first_edition;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.*;

public class FormClient {
	JFrame frame;
	JPanel contenuFenetre;
	JPanel P1;
	JPanel P2;
	JLabel L1;
	JLabel L2;
	JLabel L3;
	JTextField text1;
	JTextField text2;
	JTextField text3;
	JButton boutonOK;
	FormClient(){
		contenuFenetre = new JPanel();
		P1=new JPanel();
		P2=new JPanel();
		L1=new JLabel();
		L2=new JLabel();
		L3=new JLabel();
		L1.setText("UserName");
		L2.setText("Ip address");
		L3.setText("Port");
		text1=new JTextField();
		text2=new JTextField();
		text3=new JTextField();
		boutonOK=new JButton("Creer first_edition.Client");
		GridLayout composition=new GridLayout(1,2);
		GridLayout composition1=new GridLayout(4,1);
		contenuFenetre.setLayout(composition);
		P1.setLayout(composition1);
		P2.setLayout(composition1);
		P1.add(L1);
		P1.add(L2);
		P1.add(L3);
		P1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		P2.add(text1);
		P2.add(text2);
		P2.add(text3);
		P2.add(boutonOK);
		P2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contenuFenetre.add(P1);
		contenuFenetre.add(P2);
		contenuFenetre.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		MoteurFormClient mtr=new MoteurFormClient(this);
		boutonOK.addActionListener(mtr);
		
		
		 frame = new JFrame("JustBee");
		 frame.setContentPane(contenuFenetre);
		 frame.setBounds(100,100,500,300);
		 frame.setVisible(true);
		 frame.setResizable(false);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		FormClient fr=new FormClient();
	}
}
