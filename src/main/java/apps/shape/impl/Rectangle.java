package apps.shape.impl;

import apps.page.CanvasPage;
import apps.shape.IShape;
import apps.shape.impl.attributes.Attributes;

import java.util.ArrayList;
import java.util.Arrays;

public class Rectangle implements IShape {
    Attributes canvasAttributes = new Attributes("Should create a new rectangle, whose upper left corner is " +
            "(x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the ",
            "R",
            "x1 y1 x2 y2",
            true);

    private static final int EXPECTED_ARGUMENT_COUNT = 5;
    Line lineObject = new Line();

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
        CanvasPage canvasPage = CanvasPage.getCanvasInstance();
        if (!canvasPage.isCanvasExists()) {
            System.out.println("canvas does not exits,please create canvas before creating Rectangle");
            return false;
        }
        return (isShapeDimensionWithinCanvas(command));
    }

    private boolean isShapeDimensionWithinCanvas(String[] command) {
        return (command.length == EXPECTED_ARGUMENT_COUNT);
    }

    private ArrayList<ArrayList<Character>> buildLineRequest(String[] command) {
        try {
            CanvasPage canvasPage = CanvasPage.getCanvasInstance();
            ArrayList<ArrayList<Character>> canvas = CanvasPage.getPage();
            for (int index = 1; index < command.length; index++) {
                String[] newReq = requestBuilder(command, index);
                lineObject.isShapeConstraintValid(newReq);
                canvas = lineObject.drawShapeOnCanvas(newReq);

                CanvasPage.paint();
                canvasPage.publishCanvas(canvas);
            }
            return canvas;
        } catch (Exception e) {
            System.out.println("Exception in Rectangle Draw buildLineRequest exception=" + e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    private String[] requestBuilder(String[] command, Integer index) {
        try {
            String[] lineDrawCommand = new String[command.length];
            System.arraycopy(command, 0, lineDrawCommand, 0, command.length);
            int targetIndexToBeReplaced = index + 2;
            if (targetIndexToBeReplaced >= lineDrawCommand.length) {
                targetIndexToBeReplaced = targetIndexToBeReplaced - 4;
            }
            lineDrawCommand[targetIndexToBeReplaced] = lineDrawCommand[index];
            return lineDrawCommand;
        } catch (Exception e) {
            System.out.println("Exception in Rectangle Draw newRequest exception=" + e.getMessage() + " " + Arrays.toString(e.getStackTrace()));
        }
        return command;
    }

    @Override
    public ArrayList<ArrayList<Character>> drawShapeOnCanvas(String[] command) {
        return buildLineRequest(command);
    }

    public int getExpectedArgumentCount() {
        return EXPECTED_ARGUMENT_COUNT;
    }

}
