package minicraft;

import minicraft.level.Level;
import java.awt.Graphics;

public class State {
    private Level level;

    public State(int width, int height) {
        level = new Level(width, height);
    }

    public void render(Graphics g) {
        level.render(g);
    }
}
