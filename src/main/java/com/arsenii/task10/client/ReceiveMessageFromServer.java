package com.arsenii.task10.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReceiveMessageFromServer implements Runnable {
    private final InputStream serverInputStream;

    public ReceiveMessageFromServer(InputStream serverInputStream) {
        this.serverInputStream = serverInputStream;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(serverInputStream));
        try {
            while (true) {
                String message = bufferedReader.readLine();
                if (message != null) {
                    System.out.print("\n" + message + "\nEnter message: ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
