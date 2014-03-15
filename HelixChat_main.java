
import java.io.*;



/**
 * Created by Apcros on 15/03/14.
 */
public class HelixChat_main {

    public static void main(String[] args) throws IOException, InterruptedException {
        try {

            String nl = System.getProperty("line.separator");
            String rep;
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Welcome in Helix-Chat-Java, Please select a mode"+nl+nl+"[1][DEFAULT] - Client Mode"+nl+"[2] - Server Mode");
            rep = r.readLine();
            if (rep.equals("2")) {
                HelixChat_server.main();
            } else {
                HelixChat_client.main();
            }

        }
        catch(IOException ioE) {
            System.out.println("Error 201 : Input/Output error");
        }
        catch(InterruptedException ie) {
            System.out.println("Execution stopped.");
        }



    }
}
