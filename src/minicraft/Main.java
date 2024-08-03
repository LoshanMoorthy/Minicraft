package minicraft;

import minicraft.gfx.Renderer;
import minicraft.gfx.Spritesheet;
import minicraft.gfx.Camera;

public class Main {
    public static Spritesheet spritesheet;

    public static void main(String[] args) {
        String path = "/Users/loshansundaramoorthy/Documents/Projects/Minicraft/res/tiles.png";
        System.out.println("Loading spritesheet from: " + path);

        spritesheet = new Spritesheet(path, 8);
        Renderer.spritesheet = spritesheet;

        Camera camera = new Camera(0, 0, Renderer.WIDTH, Renderer.HEIGHT);
        Renderer.setCamera(camera);

        Window.init("MINICRAFT", 1280, 720);
        Renderer.pixels[0] = 0;
        Window.loop();
    }
}
