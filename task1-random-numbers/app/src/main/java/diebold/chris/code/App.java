package diebold.chris.code;

import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        CLI cli = new CLI();
        int exitCode = new CommandLine(cli).execute(args);
        System.exit(exitCode);
    }
}
