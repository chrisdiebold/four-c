package diebold.chris.code;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import diebold.chris.code.http.Handlers;

public class Worker implements Runnable {
    Socket socket;

    public Worker(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        String content = "";
        OutputStream out = null;
        InputStream in = null;

        try {
            out = socket.getOutputStream();
            in = socket.getInputStream();

            // get a request from the input stream
            int incominByte;

            while((incominByte = in.read()) >= 0) {
                System.out.print((char)incominByte);
            }

            out.write(Handlers.dummyHTML().getBytes(StandardCharsets.UTF_8));
            // need a file to read.

//            Scanner scanner = new Scanner();
//            while (scanner.hasNextLine()) {
//                content += scanner.nextLine();
//            }
//            scanner.close();

        } catch (IOException ex) {

        } finally {
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

            } catch(IOException ex) {}
        }
    }
}
