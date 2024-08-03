package minicraft.level.tile;

import minicraft.gfx.Spritesheet;
import minicraft.level.Level;

import java.awt.*;

public class TileAir extends Tile {
    public TileAir(int id) {
        super(id);
    }

    @Override
    public void render(Level level, int x, int y) {
        // air :)
    }
}
