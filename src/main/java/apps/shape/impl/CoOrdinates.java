package apps.shape.impl;

public class CoOrdinates<W, H> {
    private final W width;
    private final H height;

    public static <K, V> CoOrdinates<K, V> createCoOrdinates(K element0, V element1) {
        return new CoOrdinates<>(element0, element1);
    }

    public CoOrdinates(W width, H height) {
        this.width = width;
        this.height = height;
    }

    public W getWidth() {
        return width;
    }

    public H getHeight() {
        return height;
    }
}
