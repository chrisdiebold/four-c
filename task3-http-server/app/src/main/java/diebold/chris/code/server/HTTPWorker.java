package diebold.chris.code.server;

import diebold.chris.code.http.Handlers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HTTPWorker extends Thread {
    private final static Logger LOGGER = LoggerFactory.getLogger(HTTPWorker.class);

    private Socket socket;

    public HTTPWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();

            String html = Handlers.dummyHTML();
            String response = Handlers.OkResponse(html);

            out.write(response.getBytes(StandardCharsets.UTF_8));
            LOGGER.info(" *** Connection Processing Finished.");


        } catch (IOException ex) {
            LOGGER.error("Problem with communication", ex);
        }
        finally {
            // In practice, each condition would have its own catch block, but for this example, I am going to consolidate them.
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }

            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
