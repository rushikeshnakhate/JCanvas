package apps.shape;

import apps.shape.impl.Canvas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCanvas {
    private static final char REQUEST_DELIMITER = ' ';
    IShape canvasShape = new Canvas();

    @Test
    //When Canvas draw request with in-correct argument is sent
    //Then request is failed
    public void TestDrawCanvasWithInvalidRequest() {
        String request = "C 10";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertFalse(canvasShape.isCommandValid(requestItems));
    }

    @Test
    //When Canvas draw request with correct argument is sent
    //Then request is failed
    public void TestDrawCanvasWithValidRequest() {
        String request = "C 10 2";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertTrue(canvasShape.isCommandValid(requestItems));
    }

    //When Canvas is instantiated
    //Then attributes are correct
    @Test
    public void TestCanvasAttributes() {
        assertEquals(canvasShape.getCanvasAttributes().getMenuSelector(), "C");
        assertEquals(canvasShape.getCanvasAttributes().getCommandParameters(), "w h");
    }
}
