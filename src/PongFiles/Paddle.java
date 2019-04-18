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
        setColor(Color.black);
    }

   //add the other Paddle constructors
    public Paddle(int x, int y){
        super(x,y);
        speed = 5;
        setColor(Color.black);
    }
    
    public Paddle(int x, int y, int s){
        super(x, y);
        speed = s;
        setColor(Color.black);
    }
    
    public Paddle(int x, int y, int w, int h, int s){
        super(x, y, w, h);
        speed = s;
        setColor(Color.black);
    }
    
    public Paddle(int x, int y, int w, int h, Color c, int s){
        super(x, y, w, h, c);
        speed = s;
        
    }
    
    public void moveUpAndDraw(Graphics window) {

    }

    public void moveDownAndDraw(Graphics window) {

    }

   //add get methods
    
       /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
   //add a toString() method

    public String toString(){
        return getxPos() + " " + getyPos() + " " + getWidth() + " " + getHeight() + " " + getColor() + " " + getSpeed();
    }
}
