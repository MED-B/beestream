package serverside;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class MoteurServerPort implements ActionListener {
    ServerPort parent;
    NumberFormat formatNombres = NumberFormat.getInstance();
    public MoteurServerPort(ServerPort parent){
        this.parent=parent;
    }
    @Override
    public void actionPerformed(ActionEvent evenement) {
        Object sourceEvenement = evenement.getSource();
        String portTF= parent.text.getText();
        double port=5050;
        //get number from port textfield
        if (!"".equals(portTF)) {
            port =
                    // analyse la chaîne de caractères
                    formatNombres.parse(portTF, new ParsePosition(0) /* ne sert pas */).
                            // puis donne sa valeur en tant que double
                                    doubleValue();
        }
        if(sourceEvenement == parent.btn ) {
            parent.frame.setVisible(false);
            ServerApp srvapp=new ServerApp(port);

        }
    }
}
