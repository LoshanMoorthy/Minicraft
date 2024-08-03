package minicraft.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class Renderer {
    public static final int WIDTH = 256, HEIGHT = 144;
    public static int[] pixels = new int[WIDTH * HEIGHT];
    public static final int FLIP_NONE = 0x00;
    public static final int FLIP_X = 0x01;
    public static final int FLIP_Y = 0x02;
    public static final int FLIP_XY = FLIP_X | FLIP_Y;
    private static Stack<Camera> cameraStack = new Stack<>();
    public static Camera camera = new Camera();
    public static Spritesheet spritesheet;

    public static void pushCamera() {
        cameraStack.push(camera);
        camera = new Camera();
    }

    public static void popCamera() {
        camera = cameraStack.pop();
    }

    public static void setCamera(Camera cam) {
        camera = cam;
    }

    public static Camera getCamera() {
        return camera;
    }
    public static void render(int spriteX, int spriteY, int x, int y, int color, int flip) {
        int tileWidth = 8;
        int tileHeight = 8;
        int[] spritePixels = spritesheet.pixels;

        for (int yy = 0; yy < tileHeight; yy++) {
            int yp = yy;
            if ((flip & FLIP_Y) != 0) {
                yp = tileHeight - 1 - yy;
            }
            for (int xx = 0; xx < tileWidth; xx++) {
                int xp = xx;
                if ((flip & FLIP_X) != 0) {
                    xp = tileWidth - 1 - xx;
                }

                int pixelIndex = (spriteX * tileWidth + xp) + (spriteY * tileHeight + yp) * spritesheet.width;
                int pixelColor = spritePixels[pixelIndex];

                if (pixelColor != -1) {
                    int screenX = x + xx - camera.getX();
                    int screenY = y + yy - camera.getY();
                    if (screenX >= 0 && screenY >= 0 && screenX < WIDTH && screenY < HEIGHT) {
                        pixels[screenX + screenY * WIDTH] = color;
                    }
                }
            }
        }
    }

    public static void render(Graphics g, int x, int y, BufferedImage sprite) {
        g.drawImage(sprite, x, y, null);
    }

    public static void render(int[] palette, int time, int canvasWidth, int canvasHeight) {
        for (int i = 0; i < pixels.length; i++) {
            if (i % WIDTH < WIDTH / 2) {
                pixels[i] = palette[time % palette.length];
            } else {
                pixels[i] = palette[(time + 128) % palette.length];
            }
        }
    }
}