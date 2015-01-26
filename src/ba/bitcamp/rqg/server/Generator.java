package ba.bitcamp.rqg.server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.scene.shape.Line;
/**
 * Class that creates Server and connect it with Client/User.
 * @author Amra
 *
 */
public class Generator {

	public static final int PORT=1717;
	
	public static InputStream in = new DataInputStream(System.in);
	public static OutputStream out;
	private static String password = "lala" ;



	/**
	 * Method that stars connecting server with client.
	 */
	public static void startServer() {
	
		try {
		
			Scanner scan = new Scanner(System.in);
			ServerSocket server = new ServerSocket(PORT);
			
		
			while ( true){
				System.out.println("waiting..");
				Socket client = server.accept();
				
				in = client.getInputStream();

				out= client.getOutputStream();
				
//				BufferedReader incoming = new BufferedReader(
//						new InputStreamReader(client.getInputStream()) );
//				PrintWriter out = new PrintWriter( client.getOutputStream(), true);
				
				while ( true){
					System.out.println("Server: enter pasword:  ");

					String msg = "Enter password: ";
				    sendMessage(msg);
					String passwordMsg = recieveMessage();
					System.out.println(passwordMsg);
					
					
					if (passwordMsg.equals(password)){
						System.out.println("Password is correct!");
						readQuotes();
						break;
					} else {
						System.out.println("Password is not correct!");
					}	
					System.out.println("It is over!");
					client.close();
				}
			
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Method for receiving message.
	 * @return returns message in String.
	 */
	public static String recieveMessage(){
		
		/* get message */
		String bufferedStringServer = "";
		try {
			
			
			int byteLength = in.read();
			byte [] buffer = new byte [byteLength];
			
			StringBuilder sb = new StringBuilder();
			int byteRead = 0;
			while ( (byteRead += in.read(buffer)) >=0){
				sb.append(new String(buffer).replaceAll("\\s+", " "));
				
				if( byteRead >= byteLength){
					break;
				}
			}
			bufferedStringServer = sb.toString();		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bufferedStringServer;
			
	}
	
	/**
	 * Method that sends message written as String type.
	 * @param string - message that we are sending.
	 */
	public static void sendMessage(String string){
		
		try {
			out = new DataOutputStream(System.out);

			byte [] buffer = string.getBytes();
			out.write(buffer.length);
			out.write(buffer);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method that reads random quotes from file.
	 */
    public static void readQuotes(){
    	int random = (int) (1 + Math.random() * 15);

		try {
			String line = "";
			FileReader fr = new FileReader(
					"C:\\Users\\Amra\\Desktop\\quotes.txt");

			BufferedReader br = new BufferedReader(fr);
			
			for (int i = 0; i < random - 1; i++) {
				br.readLine();
			}

			line = br.readLine();
			System.out.println(line);
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Main method
	 */
	public static void main(String[] args) {
		
		try {
			startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// end of main class
}
