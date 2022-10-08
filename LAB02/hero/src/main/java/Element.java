import com.googlecode.lanterna.input.KeyStroke;

public class Element {
    Position position;
    public Element(){
        position = new Position(10,10);
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

    public void updatePos(KeyStroke key){

    }

    void moveElement(Position position){
        this.setPosition(position);
    }

    public void setPosition(Position pos){
        this.position = pos;
    }

    public int getPosX(){
        return this.position.getX();
    }
    public int getPosY(){
        return this.position.getY();
    }

}
