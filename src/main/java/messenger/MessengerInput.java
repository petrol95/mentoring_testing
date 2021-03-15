package messenger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/**
 * @author Olga Petrova
 */

public class MessengerInput {

    private BufferedReader bufferedReader;
    private Map<String, String> inputData;

    public MessengerInput(BufferedReader bufferedReader) {

    }

    public Map<String, String> inputFromFile() throws IOException {
        return Collections.EMPTY_MAP;
    }

    public Map<String, String> inputFromConsole() throws IOException {
        return Collections.EMPTY_MAP;
    }

    public void collectInputData(String line) {

    }

    public Map<String, String> getInputData() {
        return inputData;
    }
}
