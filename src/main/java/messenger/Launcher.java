package messenger;

import java.io.IOException;

/**
 * @author Olga Petrova
 */

public class Launcher {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            new Messenger().processConsoleOperation();
        } else {
            new Messenger().processFileOperation(args);
        }
    }
}