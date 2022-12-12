package com.arsenii.task10.client;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        ConnectInputMessage connectInputMessage = new ConnectInputMessage();
        Thread inputThread = new Thread(connectInputMessage);
        inputThread.start();

        ReceiveMessageFromServer receiveMessageFromServer = new ReceiveMessageFromServer(connectInputMessage.getInputStream());
        Thread receiveThread = new Thread(receiveMessageFromServer);
        receiveThread.start();
    }
}
