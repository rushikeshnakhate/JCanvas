package apps.shape;

import apps.shape.impl.FIllArea;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFillArea {
    private static final char REQUEST_DELIMITER = ' ';
    IShape fIllAreaShape = new FIllArea();

    @Test
    //When FillArea draw request with in-correct argument is sent
    //Then request is failed
    public void TestDrawFillAreaWithInvalidRequest() {
        String request = "B 10";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertFalse(fIllAreaShape.isCommandValid(requestItems));
    }

    @Test
    //When FillArea draw request with correct argument is sent
    //Then request is failed
    public void TestDrawFillAreaWithValidRequest() {
        String request = "L 10 2 12 4";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertTrue(fIllAreaShape.isCommandValid(requestItems));
    }

    //When FillArea is instantiated
    //Then attributes are correct
    @Test
    public void TestFillAreaAttributes() {
        assertEquals(fIllAreaShape.getCanvasAttributes().getMenuSelector(), "B");
        assertEquals(fIllAreaShape.getCanvasAttributes().getCommandParameters(), "x y c");
    }

    //When FillArea draw request with no canvas argument is sent
    //Then request is failed
    @Test
    public void TestDrawFillAreaWithInvalidRequestWithNoCanvas() {
        String request = "B 10 2 x";
        String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
        assertFalse(fIllAreaShape.isShapeConstraintValid(requestItems));
    }
}
