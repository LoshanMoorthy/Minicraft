package minicraft.level;

import minicraft.level.tile.*;
import minicraft.gfx.Camera;
import minicraft.gfx.Renderer;

import java.awt.Graphics;
import java.util.Random;

public class Level {
    private Tile[][] tiles;
    private int width, height;
    private Camera camera;
    private Random random = new Random();

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        this.camera = Renderer.getCamera();
        tiles = new Tile[width][height];
        generateLevel();
    }

    private void generateLevel() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int tileType = random.nextInt(4);
                switch (tileType) {
                    case 1:
                        tiles[x][y] = new TileGrass(1);
                        break;
                    case 2:
                        tiles[x][y] = new TileRock(2);
                        break;
                    case 3:
                        tiles[x][y] = new TileWater(3);
                        break;
                    default:
                        tiles[x][y] = new TileAir(0);
                        break;
                }
            }
        }
    }

    public int getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return -1;  // Return -1 if the coordinates are out of bounds
        }
        return tiles[x][y].id;
    }

    public void render(Graphics g) {
        int startX = Math.max(camera.getX() / 16, 0);
        int startY = Math.max(camera.getY() / 16, 0);
        int endX = Math.min((camera.getX() + camera.getWidth()) / 16, width);
        int endY = Math.min((camera.getY() + camera.getHeight()) / 16, height);

        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                if (tiles[x][y] != null) {
                    tiles[x][y].render(this, x, y);
                }
            }
        }
    }

    public static int toPixel(int tileCoord) {
        return tileCoord * 16;  // Assuming each tile is 16 pixels
    }
}
