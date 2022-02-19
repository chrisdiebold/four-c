package diebold.chris.code;

import java.io.IOException;
import java.util.concurrent.Callable;

import diebold.chris.code.server.ListenerThread;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

public class CLI  implements Runnable {
    @Option(names = { "-p", "--port" }, description = "TCP port number to bind too.", required = true)
    private Integer port;
    @Option(names = { "-r", "--root" }, description = "Directory to serve file from.", required = true)
    private String webRoot;

    @Override
    public void run() {
        try {
            Server.getInstance(port, webRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
