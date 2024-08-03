package minicraft.level.tile;

import minicraft.gfx.Color;
import minicraft.gfx.Renderer;
import minicraft.level.Level;


public class TileTree extends TileGround {
    public static final int COLOR = Color.get(110, 220, 141, 252);
    public static final int TRANSITION_COLOR = Color.get(110, 220, 141, 252);

    public TileTree(int id) {
        super(id);
    }

    @Override
    public void render(Level level, int x, int y) {
        Renderer.render(3, 0, Level.toPixel(x), Level.toPixel(y), COLOR, Renderer.FLIP_NONE);
    }

    @Override
    public int getColor() {
        return COLOR;
    }

    @Override
    public int getTransitionColor() {
        return TRANSITION_COLOR;
    }
}
