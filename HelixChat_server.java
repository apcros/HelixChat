import java.io.*;
import java.net.*;

/**
 * Created by Apcros on 14/03/14.
 */
public class HelixChat_server {



    public static void main() throws IOException, UnknownHostException {


        try {
            int p;
            String portString;
            ServerSocket s;
            String nl = System.getProperty("line.separator");
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Welcome in HELIX-Instant-Chat (Server mode)"+nl+"Please precise the port of the server [DEFAULT : 255]");
            portString = r.readLine();

            if (portString.equals("")) {
                    p = 255;
                } else {
                    p = Integer.parseInt(portString);
               }

            System.out.println(nl+"Initializing server..."+nl);
            s = new ServerSocket(p);
            System.out.println(nl+"Server is accepting connections on port "+p+nl);
            Socket helix = s.accept(); //ALL HEIL THE HELIX FOSSIL

            System.out.println(nl+"Connection established with "+helix.getInetAddress().toString()+" !");
            System.out.println(nl+"============================"+nl);
            DataInputStream data = new DataInputStream(helix.getInputStream());
            PrintStream input = new PrintStream(helix.getOutputStream());
            while(helix.isConnected()) {
                System.out.println(data.readUTF());
            }

        }
     catch (EOFException Eof) {
            System.out.println("Error 101 : Client disconnected ");
        }
    }

}
