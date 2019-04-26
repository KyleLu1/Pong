package PongFiles;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block {

    //instance variables

    private int speed;

    public Paddle() {
        super(10, 10);
        speed = 5;
    }
    public Paddle(int x, int y){
        setX(x); setY(y); setWidth(10); setHeight(10); speed = 5;
    }
    public Paddle(int x, int y, int s){
        setX(x); setY(y); setWidth(10); setHeight(10); speed = s;
    }
    public Paddle(int x, int y, int w, int h, int s){
        setX(x); setY(y); setWidth(w); setHeight(h); speed = s;
    }
    public Paddle(int x, int y, int w, int h, Color c, int s){
        setX(x); setY(y); setWidth(w); setHeight(h); speed = s; setColor(c);
    }
   //add the other Paddle constructors
    public void moveUpAndDraw(Graphics window) {
        this.draw(window, Color.WHITE);
        setY(getY() - speed);
        draw(window);
    }

    public void moveDownAndDraw(Graphics window) {
        this.draw(window, Color.WHITE);
        setY(getY() + speed);
        draw(window);
    }

   //add get methods
   public int getSpeed(){
       return speed;
   }
   //add a toString() method
   public String toString(){
       return "" + getX() + ", " + getY() + ", " + getWidth() + ", " + getHeight() + ", " + getColor() + " " + speed;
   }
}
