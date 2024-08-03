package minicraft;

public class Main {
    public static void main(String[] args) {
        Window.init("MINICRAFT", 1280, 720);
        Renderer.pixels[0] = 0;
        Window.loop();
    }
}
