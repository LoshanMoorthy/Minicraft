package minicraft.gfx;

public class Camera {
    public int x, y;
    public int width, height;

    public Camera() {
        this.x = 0;
        this.y = 0;
        this.width = Renderer.WIDTH;
        this.height = Renderer.HEIGHT;
    }

    public Camera(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void centerOn(int x, int y) {
        this.x = x - width / 2;
        this.y = y - height / 2;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
