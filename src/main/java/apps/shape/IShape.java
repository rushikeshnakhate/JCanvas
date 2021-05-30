package apps.shape;

import apps.shape.impl.attributes.Attributes;

import java.util.ArrayList;

public interface IShape {
    Attributes getCanvasAttributes();

    ArrayList<ArrayList<Character>> drawShapeOnCanvas(String[] request);

    boolean isCommandValid(String[] command);

    boolean isShapeConstraintValid(String[] command);

    int getExpectedArgumentCount();
}
