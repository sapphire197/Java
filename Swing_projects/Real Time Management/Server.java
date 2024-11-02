/* Real-Time Collaboration Using Sockets
This code allows users to chat and send updates in real-time.

Server Code */

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                String message;
                while ((message = reader.readLine()) != null) {
                    for (Socket socket : clients) {
                        if (socket != clientSocket) {
                            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
