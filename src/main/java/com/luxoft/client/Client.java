package com.luxoft.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 3000); //  ищем сервер по хосту и порту
        ) {

            System.out.println("Enter your message to server here:");

            Scanner scanner = new Scanner(System.in);
            String messageToServer = scanner.nextLine();

            socket.getOutputStream().write(messageToServer.getBytes());
            InputStream inputStream = socket.getInputStream();

            byte[] buffer = new byte[100];
            int count = inputStream.read(buffer);

            String respondToClient = new String(buffer, 0, count);
            System.out.println(respondToClient);

            inputStream.close();

        }
    }
}