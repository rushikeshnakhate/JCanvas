package apps.shape.impl;

import apps.page.CanvasPage;
import apps.shape.IShape;
import apps.shape.impl.attributes.Attributes;

import java.util.ArrayList;

public class Quit implements IShape {
    Attributes canvasAttributes = new Attributes("Should quit the program.",
            "Q", " ", true);

    private static final int EXPECTED_ARGUMENT_COUNT = 1;

    @Override
    public Attributes getCanvasAttributes() {
        return canvasAttributes;
    }

    @Override
    public boolean isCommandValid(String[] command) {
        return command.length == EXPECTED_ARGUMENT_COUNT;
    }

    @Override
    public boolean isShapeConstraintValid(String[] command) {
        return true;
    }

    @Override
    public int getExpectedArgumentCount() {
        return EXPECTED_ARGUMENT_COUNT;
    }

    @Override
    public ArrayList<ArrayList<Character>> drawShapeOnCanvas(String[] command) {
        return null;
    }
}
