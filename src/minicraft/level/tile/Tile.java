package minicraft.level.tile;

import minicraft.gfx.Spritesheet;
import minicraft.level.Level;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Tile {
    public static final int TILE_MAX = 256;
    public static final Tile[] TILES = new Tile[TILE_MAX];

    public final int id;
    protected BufferedImage sprite;

    public Tile(int id) {
        this.id = id;
        assert(Tile.TILES[this.id] == null);
        Tile.TILES[this.id] = this;
    }

    public abstract void render(Level level, int x, int y);
}
