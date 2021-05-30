package apps.application;

import apps.status.Status;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestIApplication {
    @Test
    // When Application is started
    // Then Application indicator is RUNNING
    public void createApplication() {
        IApplication iApplication = new IApplication();
        iApplication.getMenu().showMenu();
        assertEquals(Status.getIndicator(), Status.APP.RUNNING);
        Status.setStopIndicator();
    }
}
