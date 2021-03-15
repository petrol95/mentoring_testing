package messenger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Olga Petrova
 */

public class InputOutputTestSuite {

    public static final String TEMP_FILE = "temp.txt";
    private static final String TEMPLATE_LINE = "Dear #{username}," +
            " we would like to inform you about our #{event} on #{eventDate}." +
            " Please see #{tag} for more information.";

    private Messenger messenger;
    private Map<String, String> inputData;
    private BufferedReader mockReader;

    @BeforeEach
    public void prepareInputData() {
        messenger = new Messenger();
        mockReader = mock(BufferedReader.class);

        inputData = new HashMap<>();
        inputData.put("username", "Anna");
        inputData.put("event", "meeting");
        inputData.put("eventDate", "12.09.2020");
        inputData.put("tag", "#{meet}");
    }

    @Test
    public void shouldWriteMessageToFile(@TempDir Path tempDir) throws IOException {
        Path tempFile = tempDir.resolve(TEMP_FILE);
        DataInputOutput dataInputOutput = new FileInputOutput();
        when(mockReader.readLine()).thenReturn(TEMPLATE_LINE).thenReturn(null);

        List<String> result = new ArrayList<>();

        result.add("Dear Anna,");
        result.add(" we would like to inform you about our meeting on 12.09.2020.");
        result.add(" Please see #{meet} for more information.");

        String message = messenger.operateTemplate(inputData, mockReader);
        dataInputOutput.output(message, tempFile.toString());

        assertAll(
                () -> assertTrue(Files.exists(tempFile)),
                () -> assertLinesMatch(result, Files.readAllLines(tempFile))
        );
    }
}
