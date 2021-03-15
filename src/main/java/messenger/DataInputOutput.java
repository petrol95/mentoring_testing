package messenger;

import java.util.Map;

/**
 * @author Olga Petrova
 */

public interface DataInputOutput {

    void input(Map<String, String> dataKit, String fileName);

    void output(String message, String fileName);
}
