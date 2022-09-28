import com.googlecode.lanterna.TerminalSize;
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
    private int x = 10;
    private int y = 10;
    private boolean running = true;
    public void run(){
        draw();
    }
    private void draw(){
        try {

            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new
                    DefaultTerminalFactory()
                    .setInitialTerminalSize(terminalSize);
            Terminal terminal = terminalFactory.createTerminal();

             // handling screen
            Screen screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            // game loop should be around here TODO

            while(running){
                screen.clear();
                screen.setCharacter(x, y, TextCharacter.fromCharacter('P')[0]);
                screen.refresh();
                KeyStroke key = screen.readInput();
                processKey(key);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key){
        switch (key.getKeyType()){
            case ArrowUp :
                y--;
                break;
            case ArrowDown:
                y++;
                break;
            case ArrowRight:
                x++;
                break;
            case ArrowLeft:
                x--;
                break;
            case EOF:
                running = false;
                break;
        }

    }
}
