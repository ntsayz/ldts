import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;

public class Hero extends Element {
    public Hero(int x, int y){
        position = new Position(x,y);
        this.winHeight = y*2;
        this.winWidth = x*2;

    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        //graphics.putString(new TerminalPosition(position.getX(), position.getY()), "H");
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(winWidth * 2, winHeight * 2), ' ');
        graphics.putString(new TerminalPosition(position.getX() , position.getY() ), "\\/");
        graphics.putString(new TerminalPosition(position.getX() , position.getY() +1), "/\\");
    }
    public void updatePos(KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowUp -> this.moveElement(this.moveUp());
            case ArrowDown -> this.moveElement(this.moveDown());
            case ArrowRight -> this.moveElement(this.moveRight());
            case ArrowLeft -> this.moveElement(this.moveLeft());

        }
    }
    public void printPos(){
        System.out.println("Y: " + this.position.getY() + " X: " + this.position.getX());
    }







}
