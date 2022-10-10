import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public class Game {
    Arena arena;

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


            while(validSession){
                screen.clear();
                arena.draw(graphics);
                screen.refresh();
                key = screen.readInput();
                processKey(key);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void processKey(KeyStroke key){
        arena.processKey(key);
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


