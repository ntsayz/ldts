import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {
    Arena arena;
    private int c = 0;
    KeyStroke key;

    Game(){

    }
    private boolean validSession = true;
    public void run(){
        draw();
    }

    private void draw(){
        try {
            arena = new Arena(80,40);

            TextGraphics graphics = arena.getGraphics();
            Screen screen = arena.getScreen();



            while(validSession && arena.valid){
                screen.clear();
                arena.draw(graphics);
                screen.refresh();
                key = screen.readInput();
                processKey(key);


            }
            if(!arena.valid) {Message(graphics);validSession = false;}

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void processKey(KeyStroke key){
        c++;
        arena.processKey(key,c);
        switch (key.getKeyType()){
            case EOF:
                validSession = false;
                break;
            case Character:
                if (key.getCharacter() == 'q') validSession = false;
                break;
        }

    }
    private void Message(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#cff10c"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(80 * 2, 40 * 2), ' ');
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(80/2, 40/2), "YOU LOST");
    }
}


