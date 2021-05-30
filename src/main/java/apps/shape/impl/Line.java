package apps.shape.impl;

import apps.page.CanvasPage;
import apps.shape.IShape;
import apps.shape.impl.attributes.Attributes;


import java.util.ArrayList;

public class Line implements IShape {
    Attributes canvasAttributes = new Attributes("Should create a new line from (x1,y1) to (x2,y2).Currently" +
            " only horizontal or vertical lines are supported.Horizontal and vertical lines will be drawn " +
            "using the 'x' character.",
            "L", "x1 y1 x2 y2", true);
    char drawChar = 'x';
    CoOrdinates<Integer, Integer> firstPoint;
    CoOrdinates<Integer, Integer> secondPoint;

    private static final int EXPECTED_ARGUMENT_COUNT = 5;

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
            System.out.println("canvas does not exits,please create canvas before creating Line");
            return false;
        }
        return (isShapeDimensionWithinCanvas(command));
    }

    private boolean isShapeDimensionWithinCanvas(String[] command) {
        if (command.length == EXPECTED_ARGUMENT_COUNT) {
            setCoOrdinates(command);
            return (validateCoOrdinates(firstPoint) && validateCoOrdinates(secondPoint));
        }
        return true;
    }

    private void setCoOrdinates(String[] command) {
        firstPoint = CoOrdinates.createCoOrdinates(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
        secondPoint = CoOrdinates.createCoOrdinates(Integer.parseInt(command[3]), Integer.parseInt(command[4]));
    }

    private boolean validateCoOrdinates(CoOrdinates<Integer, Integer> point) {
        return validateCoOrdinate(point);
    }

    static boolean validateCoOrdinate(CoOrdinates<Integer, Integer> point) {
        if (CanvasPage.getDimension().getWidth() < point.getWidth() &&
                CanvasPage.getDimension().getHeight() < point.getHeight()) {
            System.out.println("Error:Incorrect Line dimension provided,expected max width=" +
                    CanvasPage.getDimension().getWidth() + " Height=" + CanvasPage.getDimension().getHeight() + ",Actual received" +
                    "width =" + point.getWidth() + " Height=" + point.getHeight());
            return false;
        }
        return true;
    }


    @Override
    public ArrayList<ArrayList<Character>> drawShapeOnCanvas(String[] command) {
        try {
            ArrayList<ArrayList<Character>> page = CanvasPage.getPage();
            for (int row = 1; row < page.size(); row++) {
                for (int column = 1; column < page.get(0).size(); column++) {
                    drawHorizontal(page, row, column);
                    drawVertical(page, row, column);
                }
            }
            return page;
        } catch (Exception e) {
            System.out.println("Exception in Line Draw method exception=" + e.getMessage());
        }

        return null;
    }

    private void drawHorizontal(ArrayList<ArrayList<Character>> page, int row, int column) {
        if (!firstPoint.getWidth().equals(secondPoint.getWidth()) && firstPoint.getHeight().equals(secondPoint.getHeight())) {
            if (firstPoint.getHeight().equals(row)) {
                if (column >= firstPoint.getWidth() && column <= secondPoint.getWidth()) {
                    page.get(row).set(column, drawChar);
                }
            }
        }
    }

    private void drawVertical(ArrayList<ArrayList<Character>> page, int row, int column) {
        if (firstPoint.getWidth().equals(secondPoint.getWidth()) && !firstPoint.getHeight().equals(secondPoint.getHeight())) {
            if (firstPoint.getWidth().equals(column)) {
                if (row >= firstPoint.getHeight() && row <= secondPoint.getHeight()) {
                    page.get(row).set(column, drawChar);
                }
            }
        }
    }

    public int getExpectedArgumentCount() {
        return EXPECTED_ARGUMENT_COUNT;
    }

}
