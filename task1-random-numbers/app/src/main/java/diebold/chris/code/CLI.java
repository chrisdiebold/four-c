package diebold.chris.code;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import picocli.CommandLine;
import picocli.CommandLine.Option;

@CommandLine.Command(mixinStandardHelpOptions = true)
public class CLI implements Callable<Integer> {
    @Option(names = { "-n", "--number" }, description = "The number of random numbers to generate", required = true)
    private Long N;

    @Option(names = { "-f", "--file" }, description = "The file to generate", required = false)
    private String filePath;

    @Override
    public Integer call() throws Exception {
        try {
            FileGenerator generator = new FileGenerator(filePath);
            List<Long> numbers = GenerateRandomNumber.generate(N);
            generator.write(numbers);
        } catch(IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return 1;
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
