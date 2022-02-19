package diebold.chris.code.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ListenerThread extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(ListenerThread.class);

    private int port;
    private String webroot;
    private ServerSocket serverSocket;

    public ListenerThread(int port, String root) throws IOException {
        this.port = port;
        this.webroot = webroot;
        this.serverSocket = new ServerSocket(this.port);
    }

    @Override
    public void run() {
        try {
            while ( serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();

                LOGGER.info(" * Connection accepted: " + socket.getInetAddress());

                HTTPWorker worker = new HTTPWorker(socket);
                worker.start();

            }
        }catch (IOException e) {
            LOGGER.error("Problem with setting socket", e);
        } finally {
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {}
            }
        }
    }

}
