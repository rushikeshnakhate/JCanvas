package apps.shape.impl;

import apps.page.CanvasPage;
import apps.shape.IShape;
import apps.shape.impl.attributes.Attributes;

import java.util.*;

import static apps.shape.impl.Line.validateCoOrdinate;

public class FIllArea implements IShape {
    Attributes canvasAttributes = new Attributes("Should fill the entire area connected to (x,y) with colour" +
            " c.The behavior of this is the same as that of the bucket fill tool in getBuildCanvas  programs.",
            "B",
            "x y c",
            true);
    private static final int EXPECTED_ARGUMENT_COUNT = 4;
    CoOrdinates<Integer, Integer> point;
    Character NO_DISPLAY_MARKER = ' ';
    Character fillChar = 'o';

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
            System.out.println("canvas does not exits,please create canvas before creating FillArea");
            return false;
        }
        return (isShapeDimensionWithinCanvas(command));
    }

    @Override
    public int getExpectedArgumentCount() {
        return EXPECTED_ARGUMENT_COUNT;
    }

    private boolean isShapeDimensionWithinCanvas(String[] command) {
        if (command.length == EXPECTED_ARGUMENT_COUNT) {
            setCoOrdinates(command);
            return (validateCoOrdinates(point));
        }
        return false;
    }

    private boolean validateCoOrdinates(CoOrdinates<Integer, Integer> point) {
        return validateCoOrdinate(point);
    }

    private void setCoOrdinates(String[] command) {
        point = CoOrdinates.createCoOrdinates(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
    }

    @Override
    public ArrayList<ArrayList<Character>> drawShapeOnCanvas(String[] command) {
        List<CoOrdinates<Integer, Integer>> visitorCollector = new LinkedList<>();
        ArrayList<ArrayList<Character>> canvas = CanvasPage.getPage();
        Queue<CoOrdinates<Integer, Integer>> fillManager = new LinkedList<>();
        fillManager.add(point);
        while (!fillManager.isEmpty()) {
            CoOrdinates<Integer, Integer> point = fillManager.remove();
            Integer height = point.getHeight();
            Integer width = point.getWidth();
            List<CoOrdinates<Integer, Integer>> neighbours = new ArrayList<>();
            populateNeighbour(neighbours, width, height);
            fillWithColour(visitorCollector, canvas, fillManager, height, width, neighbours);
        }
        return canvas;
    }

    private void fillWithColour(List<CoOrdinates<Integer, Integer>> visitorCollector,
                                ArrayList<ArrayList<Character>> canvas,
                                Queue<CoOrdinates<Integer, Integer>> fillManager,
                                Integer height, Integer width,
                                List<CoOrdinates<Integer, Integer>> neighbours) {
        for (CoOrdinates<Integer, Integer> neighbour : neighbours) {
            if (validateCoOrdinates(neighbour)
                    && !visitorCollector.contains(neighbour) &&
                    canvas.get(neighbour.getHeight()).get(neighbour.getWidth()) == NO_DISPLAY_MARKER) {
                fillManager.add(neighbour);
                visitorCollector.add(neighbour);
                canvas.get(height).set(width, fillChar);
            }
        }
    }

    private void populateNeighbour(List<CoOrdinates<Integer, Integer>> neighbours, Integer width, Integer height) {
        neighbours.add(new CoOrdinates<>(width, height));
        neighbours.add(new CoOrdinates<>(width + 1, height));
        neighbours.add(new CoOrdinates<>(width - 1, height));
        neighbours.add(new CoOrdinates<>(width, height + 1));
        neighbours.add(new CoOrdinates<>(width, height - 1));
    }
}
