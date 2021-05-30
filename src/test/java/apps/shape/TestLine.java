package apps.shape;

import apps.shape.impl.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLine {
    private static final char REQUEST_DELIMITER = ' ';
    IShape lineShape = new Line();

    @Test
    //When Line draw request with in-correct argument is sent
    //Then request is failed
    public void TestDrawLineWithInvalidRequest() {
        String request = "L 10";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertFalse(lineShape.isCommandValid(requestItems));
    }

    @Test
    //When Line draw request with correct argument is sent
    //Then request is failed
    public void TestDrawLineWithValidRequest() {
        String request = "L 10 2 12 4";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertTrue(lineShape.isCommandValid(requestItems));
    }

    //When Line is instantiated
    //Then attributes are correct
    @Test
    public void TestLineAttributes() {
        assertEquals(lineShape.getCanvasAttributes().getMenuSelector(), "L");
        assertEquals(lineShape.getCanvasAttributes().getCommandParameters(), "x1 y1 x2 y2");
    }

    //When Line draw request with no canvas argument is sent
    //Then request is failed
    @Test
    public void TestDrawLineWithInvalidRequestWithNoCanvas() {
        String request = "L 10 2";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertFalse(lineShape.isShapeConstraintValid(requestItems));
    }
}
