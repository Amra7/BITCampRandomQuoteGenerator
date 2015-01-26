package ba.bitcamp.rqg.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class getQuotesTest {

	public static void main(String[] args) {

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
}
