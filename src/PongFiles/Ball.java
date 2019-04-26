package PongFiles;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable {

    private int xSpeed;
    private int ySpeed;

    public Ball() {
        super(200, 200);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y) {
        super(x, y);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h) {
        super(x, y, w, h);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h, Color c) {
        super(x, y, w, h, c);
        xSpeed = 3;
        ySpeed = 1;
    }

    public Ball(int x, int y, int w, int h, Color c, int xs, int ys) {
        super(x, y, w, h, c);
        xSpeed = xs;
        ySpeed = ys;
    }
    //add the other Ball constructors
    //add the set methods

    public void setXSpeed(int xs) {
        xSpeed = xs;
    }

    public void setYSpeed(int ys) {
        ySpeed = ys;
    }

    public void moveAndDraw(Graphics window) {
        //draw a white ball at old ball location
        this.draw(window, Color.WHITE);
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);

        //draw the ball at its new location
        this.draw(window);
    }

    public boolean equals(Object obj) {
        Ball test = (Ball) obj;
        return this.getX() == test.getX() && this.getY() == test.getY() && this.getWidth() == test.getWidth() && this.getHeight() == test.getHeight()
                && this.getColor().equals(test.getColor()) && this.getXSpeed() == test.getXSpeed() && this.getYSpeed() == test.getYSpeed();

    }

    public boolean didCollideRight(Object obj) {
        Paddle rightPaddle = (Paddle) obj;
        Ball ball = this;
        return ball.getX() >= rightPaddle.getX() - rightPaddle.getWidth() - Math.abs(ball.getXSpeed());
    }

    public boolean didCollideLeft(Object obj) {
        Paddle leftPaddle = (Paddle) obj;
        Ball ball = this;
        return ball.getX() <= leftPaddle.getX() + leftPaddle.getWidth() + Math.abs(ball.getXSpeed());
        //return false;
    }

    public boolean didCollideTop(Object obj) {
        Block b = (Block) obj;
        Ball ball = this;
        return ball.getY() >= b.getY() && ball.getY() <= b.getY() + b.getHeight();
    }

    public boolean didCollideBottom(Object obj) {
        Block b = (Block) obj;
        Ball ball = this;
        return ball.getY() + ball.getHeight() >= b.getY() && ball.getY() + ball.getHeight() <= b.getY() + b.getHeight();
    }

    //add the get methods
    public int getXSpeed() {
        return xSpeed;
    }

    public int getYSpeed() {
        return ySpeed;
    }

    //add a toString() method
    public String toString() {
        return "" + getX() + ", " + getY() + ", " + getWidth() + ", " + getHeight() + ", " + getColor() + " " + xSpeed + " " + ySpeed;
    }
}
