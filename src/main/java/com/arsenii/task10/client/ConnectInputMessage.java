package com.arsenii.task10.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {
    private final Socket serverSocket;
    private final InputStream inputStream;

    public ConnectInputMessage() throws IOException {
        this.serverSocket = new Socket("localhost", 8888);
        this.inputStream = serverSocket.getInputStream();
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while (true) {
                String serverMessage = bufferedReader.readLine();
                if (serverMessage != null) {
                    System.out.println(serverMessage);
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("Enter message: ");
                String userMessage = userInput.readLine();
                PrintWriter printWriter = new PrintWriter(serverSocket.getOutputStream(), true);
                printWriter.println(userMessage);
                if (userMessage.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
