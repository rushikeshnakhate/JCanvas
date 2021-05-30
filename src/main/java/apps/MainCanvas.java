package apps;

import apps.application.IApplication;
import apps.status.Status;

public class MainCanvas {
    public static void main(String[] args) {
        try {
            IApplication iApplication = new IApplication();
            iApplication.getMenu().showMenu();
            while (Status.getIndicator() == Status.APP.RUNNING) {
                iApplication.selectMenu();
            }
        } catch (Exception e) {
            System.out.println("Application stopped with exception" + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
}
