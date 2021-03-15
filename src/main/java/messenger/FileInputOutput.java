package messenger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * @author Olga Petrova
 */

public class FileInputOutput implements DataInputOutput {
    @Override
    public void input(Map<String, String> dataKit, String fileName) {

    }

    @Override
    public void output(String message, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(message);
        }
    }
}
