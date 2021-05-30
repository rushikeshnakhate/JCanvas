package apps.application;

import apps.menu.Menu;
import apps.shape.impl.*;

import java.io.IOException;

public class IApplication {
    Menu menu = new Menu();

    public IApplication() {
        try {
            menu.addToMenu(new Canvas());
            menu.addToMenu(new Line());
            menu.addToMenu(new Rectangle());
            menu.addToMenu(new FIllArea());
            menu.addToMenu(new Quit());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public void selectMenu() throws IOException {
        menu.readMenuOptions();
    }
}
