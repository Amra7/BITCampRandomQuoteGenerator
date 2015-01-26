package ba.bitcamp.rqg.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
 * Class User creates user that want to connect with server
 * @author Amra
 *
 */
public class User {

	public static final String serverAddress = "127.0.0.1";
	public static final int PORT = 1717;

	public static InputStream in;
	public static OutputStream out;

	/**
	 * Connects User to the server.
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public static void connect() throws UnknownHostException, IOException {

		try {
			Socket client = new Socket(serverAddress, PORT);
			Scanner scan = new Scanner(System.in);

			in = client.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader br = new BufferedReader(isr);
//			PrintWriter out = new PrintWriter( client.getOutputStream(), true);

			while (true) {
				
				String serverMessage =recieveMessage();
				System.out.println("Server: " + serverMessage);
				System.out.println("Client: ");
				String clientMessage = scan.nextLine();
				sendMessage(clientMessage);
				client.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method for receiving message.
	 * 
	 * @return returns message in String.
	 */
	public static String recieveMessage() {

		/* get message */
		String bufferedStringServer = "";
		try {
			in = new DataInputStream(System.in);
			int byteLength = in.read();
			byte[] buffer = new byte[byteLength];

			StringBuilder sb = new StringBuilder();
			int byteRead = 0;
			while ((byteRead += in.read(buffer)) >= 0) {
				sb.append(new String(buffer).replaceAll("\\s+", " "));

				if (byteRead >= byteLength) {
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
	public static void sendMessage(String string) {

		try {
			out = new DataOutputStream(System.out);

			byte[] buffer = string.getBytes();
			out.write(buffer.length);
			out.write(buffer);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			connect();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
