package apps.status;

public class Status {
    public enum APP {
        RUNNING,
        QUIT
    }

    static public APP indicator = APP.RUNNING;

    static public APP getIndicator() {
        return indicator;
    }

    static public void setStopIndicator() {
        indicator = APP.QUIT;
    }
}
