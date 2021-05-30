package apps.processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestProcessor {
    Processor processor = new Processor();

    @Test
    // When invalid request is sent
    // Then processor handle it
    public void TestProcessRequest() {
        try {
            processor.processDrawRequest("");
        } catch (Exception e) {
            assertEquals("Shape not supported,received=,please check menu and try with correct option", e.getMessage());
        }
    }

    @Test
    //When Invalid command for draw request is provided
    //Then its handled
    public void TestisCommandValid() {
        String request = "C 10";
        boolean processFlag = processor.processDrawRequest(request);
        assertFalse(processFlag);
    }
}
