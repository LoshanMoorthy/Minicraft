package minicraft.level.tile;

import minicraft.gfx.Color;
import minicraft.gfx.Renderer;
import minicraft.level.Level;

public class TileRock extends TileGround {
    public static final int COLOR = 0x7F7F7F;
    public static final int TRANSITION_COLOR = 0x7F7F7F;

    public TileRock(int id) {
        super(id);
    }

    @Override
    public void render(Level level, int x, int y) {
        Renderer.render(1, 0, Level.toPixel(x), Level.toPixel(y), COLOR, Renderer.FLIP_NONE);
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