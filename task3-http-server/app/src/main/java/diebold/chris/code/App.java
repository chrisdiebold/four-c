/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package diebold.chris.code;

import com.sun.net.httpserver.HttpServer;

import picocli.CommandLine;

public class App {
    

    public static void main(String[] args) {
        CLI cli = new CLI();
        new CommandLine(cli).execute(args);
    }
}
