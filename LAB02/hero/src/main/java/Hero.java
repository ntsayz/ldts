import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;

public class Hero extends Element {
    public Hero(){
        position = new Position(10,10);
    }
    public void draw(Screen screen){
        screen.setCharacter(this.getPosX(),this.getPosY() , TextCharacter.fromCharacter('H')[0]);
    }
    public void updatePos(KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowUp -> this.moveElement(this.moveUp());
            case ArrowDown -> this.moveElement(this.moveDown());
            case ArrowRight -> this.moveElement(this.moveRight());
            case ArrowLeft -> this.moveElement(this.moveLeft());
        }
    }







}
