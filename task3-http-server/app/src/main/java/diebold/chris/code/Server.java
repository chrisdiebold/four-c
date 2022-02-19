package diebold.chris.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);
    private static Server instance = null;

    private int port;
    private String webRoot;


    private Server(int port, String webRoot) throws IOException {
        this.webRoot = webRoot;
        this.port = port;
        logger.info("Serving directory " + this.webRoot);
        // start a new thread to listen for a connection.
        Listener listener = new Listener(port, webRoot);
        listener.start();
    }
    public static Server getInstance(int port, String webRoot) throws IOException {
        if(instance == null) {
            instance = new Server(port, webRoot);
            logger.info("Listening on port " + port + " ....");
        }
        return instance;
    }
}