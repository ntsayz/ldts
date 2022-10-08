import com.googlecode.lanterna.screen.Screen;

public class Arena {
    private int width;
    private int height;
    public Arena(int width, int height ){

    }

    public void draw(Screen screen){
        Hero hero = new Hero();
        hero.draw(screen);
    }
}
