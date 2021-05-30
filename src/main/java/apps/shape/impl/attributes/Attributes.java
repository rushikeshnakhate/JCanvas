package apps.shape.impl.attributes;

public class Attributes {
    String description;
    String menuSelector;
    String commandParameters;
    boolean enable;

    public Attributes(String description, String menuSelector, String commandParameters, boolean enable) {
        this.commandParameters = commandParameters;
        this.description = description;
        this.menuSelector = menuSelector;
        this.enable = enable;
    }

    public String getDescription() {
        return description;
    }

    public String getMenuSelector() {
        return menuSelector;
    }

    public String getCommandParameters() {
        return commandParameters;
    }

    public boolean isEnable() {
        return enable;
    }
}
