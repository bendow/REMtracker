package PKGremtracker;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * WifiHandler sets and manages all Wifi related content and connections
 * Refer to the "ESP8266 AT Instruction Set" (link on Readme file)
 *
 * @author Basel Dadsi
 * @author Benjamin Dow
 * @author Julio Renta
 * @version 1.0
 * @since   2018-NOV-22
 */
public class WiFiHandler {
    ServerSocket ss;
    Socket x;
    PrintWriter output;
    Scanner input;
    String msg1;

    //Constructor with no arguments
    WiFiHandler(){


        try {
            ss = new ServerSocket(3000);
        } catch (Exception e) {
            System.out.println("ServerSocket Error: " + e);
        }

        try {
            x = ss.accept();
        } catch (Exception e) {
            System.out.println("ServerSocket Accept Error: " + e);
        }

        System.out.println("Connection ok \n");

        try {
            input = new Scanner(x.getInputStream());
        } catch (Exception e) {
            System.out.println("Input/Scanner Error: " + e);
        }

            try {
        output = new PrintWriter(x.getOutputStream(), true);
            } catch (Exception e) {
        System.out.println("output/Writer Error: " + e);
        }


        do {
            msg1 = input.nextLine();
            System.out.println("Message received \n");
            System.out.println(msg1);
            //System.out.println("Sending back \n");
            //output.println(msg1);

        } while (!msg1.equals("bye"));
        try {
            x.close();
        } catch (Exception e){
            System.out.println("Closing Error: " + e);
        }

        try {
            ss.close();
        } catch (Exception e){
            System.out.println("Closing Socket Error: " + e);
        }
    }

}
