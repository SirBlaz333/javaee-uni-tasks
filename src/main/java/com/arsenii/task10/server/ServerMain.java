package com.arsenii.task10.server;

public class ServerMain {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        Thread thread = new Thread(chatServer);
        thread.start();
    }
}
