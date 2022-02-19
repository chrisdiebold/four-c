package diebold.chris.code;

import diebold.chris.code.server.ListenerThread;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int port = 8082;
        String root = "C:/Users/Chris/code/fourc-coding-assessment/task3-http-server/app/src/main/resources";
        try {
            ListenerThread serverListenerThread = new ListenerThread(port, root);
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
