package apps;

import apps.application.IApplication;
import apps.processor.Processor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMainCanvas {

    @Test
    public void TestRunForMainCanvas() {
        IApplication iApplication = new IApplication();
        iApplication.getMenu().showMenu();
        Processor processor = new Processor();
        List<String> requests = new ArrayList<>();
        requests.add("C 20 4");
        requests.add("L 1 2 6 2");
        requests.add("L 6 3 6 4");
        requests.add("R 14 1 18 3");
        requests.add("B 10 3 o");
        requests.add("Q");
        for (String request : requests) {
            processor.processDrawRequest(request);
        }
    }
}
