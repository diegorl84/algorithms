package effectivejava.item5;

import java.util.function.Supplier;

public class Mosaic {
    Mosaic create(Supplier<? extends Tile> tileFactory) {
        Tile t = tileFactory.get();
        return null;
    }
}
