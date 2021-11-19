package serverside;


import java.awt.*;


import javax.swing.*;

public class ServerApp {
private double port;
	JFrame frame;
	JPanel contenuFenetre;
	JPanel P1;
	JTextArea champMessages;
	JTextField champEcriture;
	JButton btnStart;
	JButton btnStop;
	JScrollPane sp;
	
	public ServerApp(double port) {
	    this.port=port;
		
        GridBagConstraints contr = new GridBagConstraints();
        GridBagLayout disposition = new GridBagLayout();
        GridLayout composition = new GridLayout(1,2);
        contenuFenetre = new JPanel();
        P1=new JPanel();
        P1.setLayout(composition);
        contenuFenetre.setLayout(disposition);

        champMessages = new JTextArea();
        champMessages.setEnabled(false);
        champMessages.setDisabledTextColor(new Color(0, 0, 0));
        champMessages.setFont(new Font("Simplified Arabic", Font.PLAIN, 25));
        champMessages.setMaximumSize(new Dimension(500,500));
        champEcriture = new JTextField(10);
        champEcriture.setEnabled(false);
        champEcriture.setDisabledTextColor(new Color(0, 0, 0));
        champEcriture.setFont(new Font("Simplified Arabic", Font.PLAIN, 25));

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");


btnStop.setEnabled(false);


        //addition de style
        //de couleur
        btnStart.setForeground(new Color(0, 0, 0));
        btnStop.setForeground(new Color(0, 0, 0));
        btnStart.setBackground(new Color(60, 163, 48));
        btnStop.setBackground(new Color(172, 56, 89));
        //confeguration
            contr.gridx=0;
            contr.gridy=0;
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
            contr.gridy=4;
            contr.gridheight=1;
            contr.gridwidth=5;
            contr.fill = GridBagConstraints.BOTH;
            // proportion d'espace horizontal occupee par ce composant
            contr.weightx = 5;
            // proportion d'espace vertical occupee par ce composant
            contr.weighty = 1;

            // position du composant dans la cellule
            contr.anchor = GridBagConstraints.CENTER;
            contenuFenetre.add(champEcriture,contr);

            P1.add(btnStart);
            P1.add(btnStop);

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
            contenuFenetre.add(P1,contr);


        // add Actionlistener to buttons and champecriture
        MoteurServerApp actionlistener=new MoteurServerApp(this,port);
        btnStop.addActionListener(actionlistener);
        btnStart.addActionListener(actionlistener);
        champEcriture.addActionListener(actionlistener);






        //pour le cadre

        frame = new JFrame("JustBee");
        frame.setContentPane(contenuFenetre);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void main(String[] args){
        ServerApp serv=new ServerApp(2020);
    }

    public double getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
