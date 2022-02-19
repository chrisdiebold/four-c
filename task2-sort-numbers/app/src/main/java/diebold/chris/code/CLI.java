package diebold.chris.code;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(mixinStandardHelpOptions = true)
public class CLI implements Callable<Integer>{
    @Option(names = { "-f", "--file" }, description = "The file to generate", required = true)
    private String filePath;
    @Option(names = { "-a", "--asc" }, description = "Sort file contents in ascending order", required = false)
    private boolean asc;
    @Option(names = { "-d", "--desc" }, description = "Sort file contents in descending order", required = false)
    private boolean desc;

    @Override
    public Integer call() throws Exception {
        try {
            List<Long> numbers = FileParser.parse(filePath);
            Sorter.sort(numbers, asc, desc);
            for(Long l: numbers) {
                System.out.println(l);
            }
        } catch (IOException ex) {
            return 1;
        }
        return 0;
    }
}