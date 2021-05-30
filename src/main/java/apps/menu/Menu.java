package apps.menu;

import apps.processor.Processor;
import apps.shape.IShape;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Menu {

    Vector<IShape> menuItems = new Vector();
    Processor processor = new Processor();

    public void showMenu() {
        for (IShape menuItem : menuItems) {
            System.out.println(menuItem.getCanvasAttributes().getMenuSelector()
                    + " " + menuItem.getCanvasAttributes().getDescription());
        }
    }

    public Vector<IShape> getMenuItems() {
        return menuItems;
    }

    public void addToMenu(IShape shape) throws ShapeException {
        if (!shape.getCanvasAttributes().isEnable()) {
            throw new ShapeException("Error: Shape= getAttributes().menuSelector is marked as disabled,but it " +
                    "was attempted to add in console menu");
        }
        menuItems.addElement(shape);
    }


    public void readMenuOptions() throws IOException {
        System.out.println("Your selection please.\n");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String request = reader.readLine();
        if (request.isEmpty()) {
            System.out.println("Error:Incorrect argument passed,expected non-empty, actual received empty");
            return;
        }
        processor.processDrawRequest(request);
    }
}
