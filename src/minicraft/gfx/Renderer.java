package minicraft.gfx;

public class Renderer {
    public static final int WIDTH = 256, HEIGHT = 144;
    public static int[] pixels = new int[WIDTH * HEIGHT];

    public static void render(int[] palette, int time, int canvasWidth, int canvasHeight) {
        for (int y = 0; y < canvasHeight; y++) {
            for (int x = 0; x < canvasWidth; x++) {
                int colorIndex = (x + y + time) % palette.length;
                int pixelIndex = (x % WIDTH) + (y % HEIGHT) * WIDTH;
                pixels[pixelIndex] = palette[colorIndex];
            }
        }
    }
}
