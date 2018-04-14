import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientMain myClient = new ClientMain();
		Socket clientSocket;
		InetAddress serverAddress;
		String serverName = "127.0.0.1";
		Scanner sc;
		String Path = myClient.SetChooseFolder();
		try {
			serverAddress = InetAddress.getByName(serverName);
			System.out.println("Get the address of the server : " + serverAddress);

			// get a connection to the server
			Socket mySocket = new Socket(serverAddress, 45000);
			System.out.println("We got the connexion to  " + serverAddress);
			System.out.println("Will read data given by server:\n");

			// create an input stream to read data from the server
			BufferedReader buffin = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			PrintWriter pout = new PrintWriter(mySocket.getOutputStream());
			String message_distant = "";
			while (message_distant != "quit") {

				// wait for an input from the console
				sc = new Scanner(System.in);
				System.out.println("Your message :");
				message_distant = sc.nextLine();

				// write the message on the output stream
				pout.println(message_distant);
				pout.flush();
				/*
				 * //Read a line from the input buffer coming from the server message_distant =
				 * buffin.readLine(); System.out.println(message_distant);
				 */
			}

			// close the connection
			System.out.println("\nMessage read. Now dying...");
			mySocket.close();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (ConnectException e) {

			System.out.println("\n cannot connect to server");
			;
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String SetChooseFolder() {
		JFrame frame = new JFrame("");
		ChooseFolder panel = new ChooseFolder();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(panel, "Center");
		frame.setSize(panel.getPreferredSize());
		frame.setVisible(true);
		return "";
	}
}