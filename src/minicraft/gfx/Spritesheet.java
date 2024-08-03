package minicraft.gfx;

import minicraft.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Spritesheet {
    public int width, height;
    public int size;
    public int sizeSprites;
    public static int[] pixels;
    private BufferedImage sheet;

    public Spritesheet(String path, int size) {
        this.size = size;

        try {
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("File not found: " + path);
                throw new IOException("File not found: " + path);
            }
            sheet = ImageIO.read(file);
            System.out.println("Loaded spritesheet: " + path);
        } catch (IOException e) {
            throw new Error(e);
        }

        this.width = sheet.getWidth();
        this.height = sheet.getHeight();
        pixels = new int[this.width * this.height];

        assert(this.width == this.height);
        this.sizeSprites = this.width / this.size;

        int[] imagePixels = sheet.getRGB(0, 0, sheet.getWidth(), sheet.getHeight(), null, 0, sheet.getWidth());

        for (int i = 0; i < this.width * this.height; i++) {
            pixels[i] = ((imagePixels[i] >> 24) & 0xFF) != 0xFF ? -1 : (imagePixels[i] & 0xFF) / 64;
        }
    }

    public BufferedImage getSprite(int x, int y, int width, int height) {
        return sheet.getSubimage(x * size, y * size, width, height);
    }
}