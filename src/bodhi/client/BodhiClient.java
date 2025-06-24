package bodhi.client;

import java.net.Socket;
import java.util.Scanner;

public class BodhiClient
{
    public static final String HOST = "mearvk.us";

    public static final Integer PORT = 39001;

    public Socket socket;

    public Scanner scanner;

    public BodhiClient()
    {
        try
        {
            this.socket = new Socket(BodhiClient.HOST, BodhiClient.PORT);

            this.scanner = new Scanner(System.in);

            System.out.println("Connected to Remote Bodhi Server: [ "+BodhiClient.HOST+":"+BodhiClient.PORT+" ]");

            String input = "";

            while(input.equalsIgnoreCase("EXIT") || input.equalsIgnoreCase("EXIT;"))
            {
                input = scanner.next();


            }
        }
        catch (Exception e)
        {
            return;
        }


    }

    public static class OutputListener extends Thread
    {

    }

    public static class InputListener extends Thread
    {

    }
}
