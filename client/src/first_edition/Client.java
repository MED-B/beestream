package first_edition;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client extends Thread {
	private ClientApp app;
	Socket soc;
	ObjectOutputStream out;
	ObjectInputStream in;
	private String ip;
	private int port;
	private String message = "__";
	private List<String> messages=new ArrayList<String>();


	public Client(String ip, int port,ClientApp app) {
		this.app=app;
		this.ip = ip;
		this.port = port;
		try {
			soc = new Socket(ip, port);
			in= new ObjectInputStream(soc.getInputStream());
			out = new ObjectOutputStream(soc.getOutputStream());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sendMessage(String message) {
		try {
			if(soc.isConnected()) {

                out.writeObject(message);
                out.flush();
				System.out.println("message send to server");
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		try {


				while (soc.isConnected()) {


					System.out.println("refreshing socket ...");
					// message recu du serveur
				List<String> messages = (List<String>) in.readObject();
				//envoi de message null
                 out.writeObject(null);
                 out.reset();
				//display messages
				app.champMessages.setText(null);
				for(int i=0;i<messages.size();i++){
					System.out.println("updating messages..");
					app.champMessages.append(messages.get(i)+"\n");
				}
				}
			} catch (IOException | ClassNotFoundException  e) {
				e.printStackTrace();
				app.champMessages.setText(null);
				app.champMessages.append(e.toString());
			}


		System.out.println("client is alive : "+Thread.currentThread().isAlive());

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public Socket getSoc() {
		return soc;
	}

	public void setSoc(Socket soc) {
		this.soc = soc;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public static void main(String[] args){
		Client client = new Client("127.0.0.1",2020,new ClientApp("mohammed","127.0.0.1",2020));
	}
}
