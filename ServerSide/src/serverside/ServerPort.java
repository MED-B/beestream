package serverside;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.*;
public class ServerPort {
    JFrame frame;
    JPanel contenuFenetre;
    JPanel P1;

    JButton btn;
    JTextField text;
    JLabel l1;
    ServerPort(){
        contenuFenetre =new JPanel();
        P1=new JPanel();
        btn = new JButton("Create Server");
        text = new JTextField(10);
        l1=new JLabel("Port");
        GridLayout composition = new GridLayout(2,1);
        GridLayout composition2 = new GridLayout(1,2);
        contenuFenetre.setLayout(composition);
        P1.setLayout(composition2);

        P1.add(l1);
        P1.add(text);
        contenuFenetre.add(P1);
        contenuFenetre.add(btn);
        MoteurServerPort mtrp=new MoteurServerPort(this);
        btn.addActionListener(mtrp);

        frame = new JFrame("BeeServer");
        frame.setContentPane(contenuFenetre);
        frame.setBounds(200,300,300,150);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public static void main(String[] args){
        ServerPort srvp=new ServerPort();
    }
}
