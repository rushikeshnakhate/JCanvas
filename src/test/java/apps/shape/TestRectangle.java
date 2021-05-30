package apps.shape;

import apps.shape.impl.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRectangle {
    private static final char REQUEST_DELIMITER = ' ';
    IShape rectangleShape = new Rectangle();

    @Test
    //When rectangle draw request with in-correct argument is sent
    //Then request is failed
    public void TestDrawRectangleWithInvalidRequest() {
        String request = "L 10";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertFalse(rectangleShape.isCommandValid(requestItems));
    }

    @Test
    //When rectangle draw request with correct argument is sent
    //Then request is failed
    public void TestDrawRectangleWithValidRequest() {
        String request = "R 10 2 12 4";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertTrue(rectangleShape.isCommandValid(requestItems));
    }

    //When rectangle is instantiated
    //Then attributes are correct
    @Test
    public void TestRectangleAttributes() {
        assertEquals(rectangleShape.getCanvasAttributes().getMenuSelector(), "R");
        assertEquals(rectangleShape.getCanvasAttributes().getCommandParameters(), "x1 y1 x2 y2");
    }

    //When rectangle draw request with no canvas argument is sent
    //Then request is failed
    @Test
    public void TestDrawRectangleWithInvalidRequestWithNoCanvas() {
        String request = "B 10 2 10 3";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertFalse(rectangleShape.isShapeConstraintValid(requestItems));
    }
}
