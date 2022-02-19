package diebold.chris.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Listener extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(Listener.class);

    private int port;
    private String root;
    ServerSocket serverSocket;
    ExecutorService threadPool;
    

    public Listener(int port, String root) throws IOException {
        this.port = port;
        this.root = root;
        serverSocket = new ServerSocket(this.port);
        threadPool = Executors.newFixedThreadPool(25); // random number...
    }


    @Override
    public void run() {
        while(serverSocket.isBound() && !serverSocket.isClosed()) { // keep alive
            try {
                // allow socket to accept requests.
                Socket socket = serverSocket.accept();
                logger.info("**** Connected on " + socket.getInetAddress());

                threadPool.submit(new Worker(socket));
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    if(serverSocket != null) {
                        serverSocket.close();
                    }
                } catch(Exception ex) {
                   ex.printStackTrace();
                }
                
            }
        }    
    }
}
