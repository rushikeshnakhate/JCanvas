package apps.page;

import java.util.ArrayList;
import java.util.Objects;

public class CanvasPage {
    static ArrayList<ArrayList<Character>> page = new ArrayList();
    private static CanvasPage canvasSingleInstance = null;

    private CanvasPage() {
    }

    static CanvasPageDimension dimension = new CanvasPageDimension();

    public void publishCanvas(ArrayList<ArrayList<Character>> page) {
        dimension.setHeight(page.size());
        dimension.setWidth(page.get(0).size());
    }

    public static CanvasPage getCanvasInstance() {
        return Objects.requireNonNullElseGet(canvasSingleInstance, CanvasPage::new);
    }

    static public void paint() {
        for (ArrayList<Character> characters : page) {
            for (Character character : characters) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    public static CanvasPageDimension getDimension() {
        return dimension;
    }

    public boolean isCanvasExists() {
        return !page.isEmpty();
    }

    public static ArrayList<ArrayList<Character>> getPage() {
        return page;
    }
}
