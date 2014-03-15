import java.io.*;
import java.net.*;

/**
 * Created by Apcros on 14/03/14.
 */
public class HelixChat_client {

    public static void main() throws IOException, InterruptedException {

        //Debut de la declaration des variables

        int port = 255;
        String rep = "y";
        String msg = "";
        String nick = "default";
        String portString;
        String ipString;
        Socket s;
        String nl = System.getProperty("line.separator");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Welcome in HELIX-Instant-Chat (Client mode)"+nl+"What is your nickname ?");
        nick = r.readLine();

        System.out.println(nl+"Enter the ip of the server :");
        ipString = r.readLine();

        System.out.println(nl+"Enter the port of the server [DEFAULT : 255]");
        portString = r.readLine();
        if (portString.equals("")) {
            port = 255;
        } else {
            port = Integer.parseInt(portString);
        }
        System.out.println(port);

        //Debut de l'instanciation des objets
        try {

            InetAddress ip = InetAddress.getByName(ipString);
            System.out.println(nl+"Connecting to "+ ipString +" ...");
            s = new Socket(ip, port);
            DataOutputStream output = new DataOutputStream(s.getOutputStream());
            System.out.println(nl+"Connection established with "+ ipString + " !"+nl);
            System.out.println(nl+"============================"+nl);

                while (!(rep.equals("q"))) {
                    rep = "y";
                    System.out.println("Message : ");
                    msg = r.readLine();
                    System.out.println("Your message is : "+nl+msg+nl+nl+"Do you want to send ? (Y(es)/n(o)/q(uit)");
                    rep = r.readLine();
                    if (rep.equals("y") || rep.equals("")) {
                        output.writeUTF(nick + " say : " + msg);
                        System.out.println(nl+"Message sended !");
                    }
                    if (rep.equals("n")) {
                        System.out.println(nl+"Cancelled.");
                    }
                }
                output.flush();
                output.close();
                System.out.println("Connection closed.");
                Thread.sleep(600);
                System.out.println("Client will terminate in 3 seconds");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");
                Thread.sleep(1000);
                System.out.print(".");

        }
        catch (SocketException se){
            System.out.println("Error 001 : Socket exception");
        }
        catch (UnknownHostException hue) { // HUE HUE HUE HUE
            System.out.println("Error 002 : Host Unknown");
        }








    }
    }

