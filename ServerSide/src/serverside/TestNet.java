package serverside;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestNet {
    public static void main(String[] args){
        try{
            InetAddress adrLocale = InetAddress.getLocalHost();
            System.out.println("Adresse locale = "+adrLocale.getHostAddress());
            InetAddress adrServeur = InetAddress.getByName("java.sun.com");
            System.out.println("Adresse Sun = "+adrServeur.getHostAddress());
            InetAddress[] adrServeurs = InetAddress.getAllByName("www.facebook.com");
            System.out.println("Adresse microsoft :  ");
            for(int i =0; i<adrServeurs.length;i++){
                System.out.println("  "+adrServeurs[i].getHostAddress());
            }
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
