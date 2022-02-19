package diebold.chris.code;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileGenerator {
    private String defaultFileName;
    private String extension;
    private String name;
    private String formattedName;
    private File fileToWrite;

    public FileGenerator(String fileFromCLI) throws IOException {
        defaultFileName = "random-numbers";
        extension = ".txt"; // because windows....

        // could use an Optional here.... 
        if(fileFromCLI == null) {
            name = defaultFileName;
        } else {
            // strip off extension if there.
            int extensionIndex = fileFromCLI.length() -4;
            if(fileFromCLI.charAt(extensionIndex) == '.') {
                name = fileFromCLI.substring(0, extensionIndex);
                extension = fileFromCLI.substring(extensionIndex);
            }
        }
        formattedName = name + extension;
        fileToWrite = new File(formattedName);
    }

    public String getFileName() {
        return name;
    }

    public String getDefaultName() {
        return defaultFileName;
    }

    public String getExtension() {
        return extension;
    }

    public File getFile() {
        return fileToWrite;
    }

    public void write(List<Long> numbers) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(formattedName));
        PrintWriter pw = new PrintWriter(fileWriter);
        for(Long l : numbers) {
            pw.println(l);
        }
        pw.close();
       
    }
}
