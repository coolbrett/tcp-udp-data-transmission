package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;


public class WisdomWordsCLTCP {

    public static void main(String[] args){
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        System.out.println("Connecting to " + host + " on port " + port);

        try{
            Socket socket = new Socket(InetAddress.getByName(host), port);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            int size = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Client received size: " + size);

            int random = new Random().nextInt(size + 1);
            System.out.println("Client's random number: " + random);
            printWriter.println(random);

            String saying = bufferedReader.readLine();
            System.out.println("Client received saying: " + saying);

            socket.close();
            printWriter.close();
            bufferedReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
