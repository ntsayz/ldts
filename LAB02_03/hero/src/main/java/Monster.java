import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Monster extends Element{

    Monster(int x, int y){
        super(x,y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(" #ce3514"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(winWidth * 2, winHeight * 2), ' ');
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }


}
