import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.List;

public class Arena {
    private int width;
    private int height;
    //private KeyStroke key;
    private Screen screen;
    TextGraphics graphics;
    Hero hero;
    private List<Wall> walls;
    public Arena(int width, int height ){
        hero = new Hero(width/2,height/2); //makes sure hero always spawns at the center
        this.width = width;
        this.height = height;
    }

    public void draw(TextGraphics graphics) throws IOException{
        hero.printPos();
        hero.draw(graphics);


    }
    public TextGraphics getGraphics() throws IOException {
        TerminalSize terminalSize = new TerminalSize(this.width, this.height);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        // handling screen
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();

        this.graphics = this.screen.newTextGraphics();
        this.graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        this.graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        return this.graphics;
    }
    public Screen getScreen(){
        return this.screen;
    }
    public void processKey(KeyStroke key){
        hero.updatePos(key);
    }


}
