package fr.apcros.helixchat;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * Created by Apcros on 14/03/14.
 */
public class HelixServer implements Runnable {


    JTextArea chatZone;
      HelixClient hc;
      JButton connect;
      JButton send;
    public HelixServer(JTextArea chatZone, HelixClient hc, JButton connect, JButton send) {
        this.chatZone = chatZone;
        chatZone.setText(chatZone.getText()+"\n"+"Initializing HelixChat..."+"\n");
        this.hc =  hc;
        this.connect = connect;
        this.send = send;
    }
    public void established() {
        
    }

    @Override
    public void run() {
        try {
            int p= 255;

            ServerSocket s;
          
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        


            s = new ServerSocket(p);
            chatZone.setText(chatZone.getText()+"Accepting chats requests on port "+p+"\n");
            Socket helix = s.accept(); //ALL HEIL THE HELIX FOSSIL

            chatZone.setText(chatZone.getText()+"Connection established with "+helix.getInetAddress().toString()+" !"+"\n"+"============================"+"\n");
            hc.Connect(helix.getInetAddress());
            connect.setEnabled(false);
            send.setEnabled(true);
            DataInputStream data = new DataInputStream(helix.getInputStream());
            PrintStream input = new PrintStream(helix.getOutputStream());
            while(helix.isConnected()) {
                chatZone.setText(chatZone.getText()+data.readUTF()+"\n");
            }

        }
     catch (EOFException Eof) {
            System.out.println("Error 101 : Client disconnected ");
        } catch (IOException ex) {
            Logger.getLogger(HelixServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
