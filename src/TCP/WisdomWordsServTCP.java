package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WisdomWordsServTCP {

    public static void main(String[] args){
        try {
            WisdomWords wisdomWords = new WisdomWords(args[0]);
            int size = wisdomWords.getSize();

            ServerSocket serverSocket = new ServerSocket(5000);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println(size);
                int index = Integer.parseInt(bufferedReader.readLine());
                if (index < size) {
                    System.out.println("Server index received: " + index);
                    String saying = wisdomWords.getWisdom(index);
                    System.out.println("Server sending saying: " + saying);
                    printWriter.println(saying);
                }else {
                    System.out.println("Server: Index out of bounds");
                }
                socket.close();
                inputStreamReader.close();
                bufferedReader.close();
                printWriter.close();
            }
            serverSocket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
