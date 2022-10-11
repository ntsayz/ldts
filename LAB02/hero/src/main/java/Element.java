import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class Element {
    Position position;
    int winWidth, winHeight;
    public Element(int x, int y){
        this.position = new Position(x,y);
    }
    public void draw(TextGraphics graphics){

    }

    public Position moveUp(){
        return new Position(this.getPosX(),this.getPosY()-1);
    }
    public Position moveDown(){
        return new Position(this.getPosX(),this.getPosY()+1);
    }
    public Position moveLeft(){
        return new Position(this.getPosX()-1,this.getPosY());
    }
    public Position moveRight(){
        return new Position(this.getPosX()+1,this.getPosY());
    }
    public void setPosition(Position pos){
        this.position = pos;
    }
    public Position getPosition(){
        return this.position;
    }
    public int getPosX(){
        return this.position.getX();
    }
    public int getPosY(){
        return this.position.getY();
    }



}
