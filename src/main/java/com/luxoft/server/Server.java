package com.luxoft.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(3000);

        System.out.println("Please, write your message here");
        Socket socket = server.accept();

        while (true) {
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[100];
            int counterClients = inputStream.read(buffer);

            String messageToServer = new String(buffer, 0, counterClients);
            String respondToClient = "Echo: " + messageToServer;

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(respondToClient.getBytes());

            inputStream.close();
            outputStream.close();
        }
    }
}