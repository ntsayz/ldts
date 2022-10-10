import com.googlecode.lanterna.input.KeyStroke;

public class Element {
    Position position;
    int winWidth, winHeight;
    public Element(int x, int y){
        this.position = new Position(x,y);
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

    public Position updatePos(KeyStroke key){
        return this.position;
    }

    void moveElement(Position toPos){
        if(elementCanMove(toPos)) this.setPosition(toPos);
        this.setPosition(this.position);
    }
    public boolean elementCanMove(Position toPos){
        //System.out.println(this.winHeight*1.25);
        if(toPos.getX() < 0 || toPos.getX() >= this.winWidth*0.983){return false;}
        if(toPos.getY() < 0 || toPos.getY() >= this.winHeight*0.983){return false;}

        return true;
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
