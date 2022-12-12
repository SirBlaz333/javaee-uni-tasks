package com.arsenii.task10.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {
    private final Socket socket;
    private final int id;
    private final ChatServer chatServer;

    public ClientThread(Socket socket, int id, ChatServer chatServer) {
        this.socket = socket;
        this.id = id;
        this.chatServer = chatServer;
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.printf("Client %d is connected%n", id);
            while (true) {
                String message = bufferedReader.readLine();
                if (message.equals("exit")) {
                    break;
                }
                System.out.printf("Client %d: %s%n", id, message);
                chatServer.sendMessage(id, message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
