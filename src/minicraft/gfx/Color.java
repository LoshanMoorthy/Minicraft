package minicraft.gfx;

public class Color {
    public static int get(int a, int b, int c, int d) {
        return ((a & 0xFF) << 24) |
               ((b & 0xFF) << 16) |
               ((c & 0xFF) << 8)  |
               (d & 0xFF);
    }
}
