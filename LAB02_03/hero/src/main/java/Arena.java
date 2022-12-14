import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private final int width;
    private final int height;
    //private KeyStroke key;
    private Screen screen;
    TextGraphics graphics;
    Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public boolean valid = true;
    public Arena(int width, int height ){
        hero = new Hero(width/2,height/2); //makes sure hero always spawns at the center
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = this.createMonsters();
    }

    public void draw(TextGraphics graphics) throws IOException{
        hero.draw(graphics);
        for (Wall wall : walls) wall.draw(graphics);
        for(Coin coin: coins) coin.draw(graphics);
        for(Monster monster: monsters){monster.draw(graphics);}


    }
    public void processKey(KeyStroke key, int c){
        //Position pos = hero.updatePos(key);
        switch (key.getKeyType()) {
            case ArrowUp -> moveElement(hero.moveUp());
            case ArrowDown -> moveElement(hero.moveDown());
            case ArrowRight -> moveElement(hero.moveRight());
            case ArrowLeft -> moveElement(hero.moveLeft());
        }
        if(c%4==0)moveMonsters();
        retrieveCoins();
    }

    private List<Wall> createWalls() {
        this.walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }
    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            monsters.add(new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return monsters;
    }
    private void addCoins(){
        Random random = new Random();
        coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
    }
    private void retrieveCoins() {
        for (Coin coin : coins) {
            if (this.hero.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                addCoins();
                break;
            }
        }


    }
    public Screen getScreen(){
        return this.screen;
    }

    void moveElement(Position toPos){
        if(elementCanMove(toPos)) this.hero.setPosition(toPos);
    }
    void moveE(Position toPos,Monster monster){
        if(elementCanMove(toPos)) monster.setPosition(toPos);
    }
    private void moveMonsters(){
        for(Monster monster: monsters){
            move(monster);
        }
        verifyMonsterCollisions();
    }

    private boolean verifyMonsterCollisions(){
        for(Monster monster: monsters){
            if(monster.getPosition().equals(this.hero.getPosition())) {valid = false;return true;}
        }
        return false;
    }
    public void move(Monster monster){
        if(this.hero.position.getY() > monster.position.getY()){ moveE(monster.moveDown(),monster);}
        if(this.hero.position.getY() < monster.position.getY()){ moveE(monster.moveUp(),monster);}
        if(this.hero.position.getX() < monster.position.getX()){ moveE(monster.moveLeft(),monster);}
        if(this.hero.position.getX() > monster.position.getX()){ moveE(monster.moveRight(),monster);}

    }
    private boolean elementCanMove(Position toPos){
        //if(toPos.getX() < 0 || toPos.getX() >= width*0.983){return false;}
        //if(toPos.getY() < 0 || toPos.getY() >= height*0.983){return false;}

        for(Wall wall: this.walls){
            if(wall.getPosition().equals(toPos)) {return false;}
        }
        return true;
    }

    public TextGraphics getGraphics() throws IOException {
        TerminalSize terminalSize = new TerminalSize(this.width, this.height);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        // handling screen
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);
        this.screen.startScreen();
        this.screen.doResizeIfNecessary();

        this.graphics = this.screen.newTextGraphics();
        this.graphics.setBackgroundColor(TextColor.Factory.fromString("#140014"));
        this.graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        return this.graphics;
    }





}
