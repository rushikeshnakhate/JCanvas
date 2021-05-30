package apps.shape.impl;

import apps.page.CanvasPage;
import apps.shape.IShape;
import apps.shape.impl.attributes.Attributes;

import java.util.ArrayList;

public class Canvas implements IShape {
    Attributes canvasAttributes = new Attributes("Should create a new canvas CanvasPage of width w and height h.",
            "C",
            "w h",
            true);
    private static final int EXPECTED_ARGUMENT_COUNT = 3;
    private static final int MARGIN = 2;
    CoOrdinates<Integer, Integer> point;
    Character ROW_MARKER = '-';
    Character COL_MARKER = '|';
    Character NO_DISPLAY_MARKER = ' ';

    public int getExpectedArgumentCount() {
        return EXPECTED_ARGUMENT_COUNT;
    }

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
        if (command.length == EXPECTED_ARGUMENT_COUNT) {
            point = CoOrdinates.createCoOrdinates(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<ArrayList<Character>> drawShapeOnCanvas(String[] command) {
        try {
            ArrayList<ArrayList<Character>> canvasPage = CanvasPage.getPage();
            for (int row = 0; row < point.getHeight() + MARGIN; row++) {
                ArrayList<Character> pageElement = new ArrayList<>();
                for (int column = 0; column < (point.getWidth() + MARGIN); column++) {
                    if (row == 0 || row == (point.getHeight() - 1 + MARGIN)) {
                        pageElement.add(ROW_MARKER);
                    } else if (column == 0 || column == (point.getWidth() - 1 + MARGIN)) {
                        pageElement.add(COL_MARKER);
                    } else {
                        pageElement.add(NO_DISPLAY_MARKER);
                    }
                }
                canvasPage.add(pageElement);
            }
            return canvasPage;
        } catch (Exception e) {
            System.out.println("Exception in Canvas Draw method exception=" + e.getMessage());
        }
        return null;
    }

}
