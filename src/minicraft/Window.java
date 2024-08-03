package minicraft;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Window {
    public static JFrame frame;
    public static Canvas canvas;
    public static BufferStrategy bufferStrategy;
    public static int width, height;
    public static boolean close = false;
    public static int fps = 0;
    public static int tps = 0;
    public static long lastSecond = 0;
    public static int frames = 0;
    public static int ticks = 0;
    private static int time = 0;  // Incremental time value
    private static BufferedImage image = new BufferedImage(Renderer.WIDTH, Renderer.HEIGHT, BufferedImage.TYPE_INT_RGB);
    private static int[] imagePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public static void init(String title, int width, int height) {
        Window.width = width;
        Window.height = height;

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(width, height));
        frame.setResizable(false);

        canvas = new Canvas();
        canvas.setSize(new Dimension(width, height));
        canvas.setVisible(true);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
    }

    private static int[] generatePalette() {
        int[] result = new int[256];
        for (int i = 0; i < 256; i++) {
            result[i] = Color.HSBtoRGB(i / 256f, 1, 1);
        }
        return result;
    }

    public static void loop() {
        int[] palette = generatePalette();
        long lastTime = System.nanoTime();
        final double nsPerTick = 1000000000.0 / 60.0;
        long now;
        double delta = 0;

        while (!close) {
            now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;
            boolean shouldRender = false;

            while (delta >= 1) {
                ticks++;
                time++;  // Increment the time value on each tick
                delta -= 1;
                shouldRender = true;
            }

            if (shouldRender) {
                frames++;
                Renderer.render(palette, time, canvas.getWidth(), canvas.getHeight());
                draw();
            }

            if (System.currentTimeMillis() - lastSecond >= 1000) {
                lastSecond += 1000;
                fps = frames;
                tps = ticks;
                frames = 0;
                ticks = 0;
                System.out.println("FPS: " + fps + " TPS: " + tps);
            }
        }
    }

    private static void draw() {
        BufferStrategy bs = bufferStrategy;
        if (bs == null) {
            canvas.createBufferStrategy(2);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        System.arraycopy(Renderer.pixels, 0, imagePixels, 0, Renderer.pixels.length);
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        g.dispose();
        bs.show();
    }
}
