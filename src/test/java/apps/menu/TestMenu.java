package apps.menu;

import apps.shape.IShape;
import apps.shape.impl.Canvas;
import org.junit.jupiter.api.Test;

public class TestMenu {
    @Test
    //When items are created for menu
    //Then item are added to menu list
    public void createMenu() throws ShapeException {
        Menu menu = new Menu();
        IShape item = new Canvas();
        menu.addToMenu(item);
        assert menu.getMenuItems().contains(item);
    }

}
