package com.arsenii.task10.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer implements Runnable {
    public static final int SERVER_PORT = 8888;
    private final Map<Integer, Socket> socketMap = new HashMap<>();

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Server is started");
            int clientNumber = 1;
            while (true) {
                Socket client = serverSocket.accept();
                Thread clientThread = new Thread(new ClientThread(client, clientNumber, this));
                clientThread.setDaemon(true);
                clientThread.start();
                socketMap.put(clientNumber++, client);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(int clientNumber, String message) {
        for (int connectedClientNumber : socketMap.keySet()) {
            if (clientNumber == connectedClientNumber) {
                continue;
            }
            System.out.printf("Client number %d has sent message: %s%n", clientNumber, message);
            try (BufferedWriter outputUser =
                         new BufferedWriter(
                                 new OutputStreamWriter(
                                         socketMap.get(clientNumber).getOutputStream()))) {
                outputUser.write(String.format("Client %d: %s", clientNumber, message));
                outputUser.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
