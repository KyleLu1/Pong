package PongFiles;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {

    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private Color color;

    public Block() {
        xPos = 0; yPos = 0; width = 0; height = 0; color = Color.BLACK;
    }

    //add other Block constructors - x , y , width, height, color
    public Block(int x, int y, int w, int h){
        xPos = x; yPos = y; width = w; height = h; color = Color.BLACK;
    }
    public Block(int x, int y, int w, int h, Color c){
        xPos = x; yPos = y; width = w; height = h; color = c;
    }
    
    public Block(int x, int y){
        xPos = x; yPos = y; width = 10; height = 10; color = Color.BLACK;
    }
    public void setPos(int x, int y){
        xPos = x; yPos = y;
    }
    public void setX(int xPos) {
        this.xPos = xPos;
    }

    public void setY(int yPos) {
        this.yPos = yPos;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void setColor(Color c){
        color = c;
    }
    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void draw(Graphics window, Color col) {
        window.setColor(col);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public boolean equals(Object obj) {
        Block test = (Block) obj;
        return this.getX() == test.getX() && this.getY() == test.getY() && this.getWidth() == test.getWidth() && this.getHeight() == test.getHeight() && this.getColor().equals(test.getColor());
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

   //add a toString() method  - x , y , width, height, color
    public String toString(){
        return "" + xPos + ", " + yPos + ", " + width + ", " + height + ", " + color;
    }
    
    
}
