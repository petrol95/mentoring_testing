package messenger;

import java.util.Map;

/**
 * @author Olga Petrova
 */

public class ConsoleInputOutput implements DataInputOutput {
    @Override
    public void input(Map<String, String> dataKit, String inputFile) {

    }

    @Override
    public void output(String message, String outputFile) {
        System.out.println(message);
    }
}
