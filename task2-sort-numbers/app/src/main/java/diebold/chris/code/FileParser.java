package diebold.chris.code;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {
    public static List<Long> parse(String path) throws IOException {
        List<Long> result = new ArrayList<>();
        File file = new File(path);
        if(file.exists()) {
            long number;
            Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                try {
                    number = Long.parseLong(sc.nextLine());
                } catch (NumberFormatException ex) {
                    continue;
                }
                result.add(number);
            }
        } else {
            throw new IOException(path + " does not exist");
        }
        return result;
    }
}
