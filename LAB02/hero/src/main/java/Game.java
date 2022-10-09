import com.googlecode.lanterna.*;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.io.IOException;

public class Game {
    private boolean validSession = true;
    public void run(){
        draw();
    }

    private void draw(){
        try {

            Screen screen = windowInitialization();
            Hero hero = new Hero();

            while(validSession){
                screen.clear();
                hero.draw(screen);
                screen.refresh();
                KeyStroke key = screen.readInput();
                processEvent(key);
                hero.updatePos(key);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Screen windowInitialization() throws IOException {
            TerminalSize terminalSize = new TerminalSize(60, 30);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

            // handling screen
            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            return screen;
    }

    private void processEvent(KeyStroke key){
        switch (key.getKeyType()){
            case EOF:
                validSession = false;
                break;
            case Character:
                if (key.getCharacter() == 'q') validSession = false;
                break;
        }

    }
}


