package apps.processor;

import apps.page.CanvasPage;
import apps.shape.IShape;
import apps.shape.impl.Canvas;
import apps.shape.impl.FIllArea;
import apps.shape.impl.Line;
import apps.shape.impl.Rectangle;
import apps.status.Status;

import java.util.ArrayList;
import java.util.Arrays;

public class Processor {
    private static final char REQUEST_DELIMITER = ' ';

    public boolean processDrawRequest(String request) {
        try {
            String[] requestItems = request.split(String.valueOf(REQUEST_DELIMITER));
            if (requestItems.length > 0) {
                if (isAppQuitRequest(requestItems[0])) {
                    return true;
                }
                IShape shape = getShapeInstance(requestItems[0]);
                if (shape == null) {
                    return false;
                }
                if (!isCommandValid(requestItems, shape)) return false;
                if (!shape.isShapeConstraintValid(requestItems)) return false;

                CanvasPage canvasPage = CanvasPage.getCanvasInstance();
                ArrayList<ArrayList<Character>> canvas = shape.drawShapeOnCanvas(requestItems);
                canvasPage.publishCanvas(canvas);
                CanvasPage.paint();
                return true;
            }
        } catch (
                Exception e) {
            System.out.println("Exception in Processor processDrawRequest=" + Arrays.toString(e.getStackTrace()));
            e.printStackTrace(System.out);
        }
        return true;
    }

    private boolean isCommandValid(String[] requestItems, IShape shape) {
        if (!shape.isCommandValid(requestItems)) {
            System.out.println("Incorrect argument provided,\nexpected=" +
                    shape.getCanvasAttributes().getMenuSelector() + " " + shape.getCanvasAttributes().getCommandParameters() + " "
                    + shape.getCanvasAttributes().getDescription() + ", argument count=" + shape.getExpectedArgumentCount() + " " +
                    "\nactual received='" + Arrays.toString(requestItems) + "' count=" + requestItems.length);
            return false;
        }
        return true;
    }

    public IShape getShapeInstance(String requestItem) {
        try {
            switch (requestItem) {
                case "C":
                    return new Canvas();
                case "L":
                    return new Line();
                case "B":
                    return new FIllArea();
                case "R":
                    return new Rectangle();
            }
            throw new InvalidRequestException("Error:Shape not supported,received=" + requestItem + ",please check menu and " +
                    "try with correct option");
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return null;
        }
    }

    public boolean isAppQuitRequest(String requestItem) {
        if (requestItem.equals("Q")) {
            System.out.println("Application Stopped request=`Q` is received,Application will stop.");
            Status.setStopIndicator();
            return true;
        }
        return false;
    }
}
