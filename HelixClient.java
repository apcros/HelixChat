package fr.apcros.helixchat;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Apcros on 14/03/14.
 */
public class HelixClient {
    private String nick;
    private Socket s;
    DataOutputStream output;
    
    public HelixClient(String nick) {
        this.nick = nick;
    }


    public boolean Connect(String ipString) {
        boolean status = true;
        try {
           
            InetAddress ip = InetAddress.getByName(ipString);
            
            s = new Socket(ip, 255);
            output = new DataOutputStream(s.getOutputStream());
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(HelixClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelixClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    public boolean Connect(InetAddress ip) {
           boolean status = true;
        try {
 
            s = new Socket(ip, 255);
            output = new DataOutputStream(s.getOutputStream());
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(HelixClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HelixClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    public void Send(String msg) {
        try {
            output.writeUTF("["+nick+"]"+" : "+msg);
        } catch (IOException ex) {
            Logger.getLogger(HelixClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void changeNick(String nick) {
        this.nick = nick;
    }







    
    }

