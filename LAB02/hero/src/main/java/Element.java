import com.googlecode.lanterna.input.KeyStroke;

public class Element {
    Position position;
    int winWidth, winHeight;
    public Element(){}


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
        this.setPosition(this.position);
    }

    public void setPosition(Position pos){
        this.position = pos;
    }

    public Position getPos(){
        return this.position;
    }
    public int getPosX(){
        return this.position.getX();
    }
    public int getPosY(){
        return this.position.getY();
    }

    public boolean elementCanMove(Position toPos){
        //System.out.println(this.winHeight*1.25);
        if(toPos.getX() < 0 || toPos.getX() >= this.winWidth*0.983){return false;}
        if(toPos.getY() < 0 || toPos.getY() >= this.winHeight*0.983 -1){return false;}
        return true;
    }

}
