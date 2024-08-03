package minicraft.level.tile;

import minicraft.gfx.Color;
import minicraft.gfx.Renderer;
import minicraft.level.Level;

public class TileWater extends TileGround {
    public static final int COLOR = 0x0000FF;
    public static final int TRANSITION_COLOR = 0x0000FF;

    public TileWater(int id) {
        super(id);
    }

    @Override
    public void render(Level level, int x, int y) {
        Renderer.render(4, 0, Level.toPixel(x), Level.toPixel(y), COLOR, Renderer.FLIP_NONE);
    }

    @Override
    public boolean isAnimated() {
        return true;
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
