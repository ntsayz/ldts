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

    void moveElement(Position toPos){
        if(elementCanMove(toPos)) this.setPosition(toPos);
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

    public boolean elementCanMove(Position toPos){
        if(toPos.getX() < 0 || toPos.getX() >= 59.5) return false;
        if(toPos.getY() < 0 || toPos.getY() >= 29.5) return false;
        return true;
    }

}
