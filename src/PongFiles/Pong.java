package PongFiles;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {

    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private boolean[] keys;
    private BufferedImage back;

    public Pong() {
        //set up all variables related to the game
        
        ball = new Ball(350,200,30,50,Color.BLUE,3,3);
        leftPaddle = new Paddle(40, 200, 15, 75, 5);
        rightPaddle = new Paddle(730, 200, 15, 75, 5);
        

        

        keys = new boolean[4];
        keys = new boolean[]{false, false, false, false};

        setBackground(Color.WHITE);
        setVisible(true);

        new Thread(this).start();
        addKeyListener(this);		//starts the key thread to log key strokes
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shop of the current screen and same it as an image
        //that is the exact same width and height as the current screen
        if (back == null) {
            back = (BufferedImage) (createImage(getWidth(), getHeight()));
        }

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();

        ball.moveAndDraw(graphToBack);
        leftPaddle.draw(graphToBack);
        rightPaddle.draw(graphToBack);

        //see if ball hits left wall or right wall
        if (!(ball.getxPos() >= 10 && ball.getxPos() <= 780)) {
            ball.setxSpeed(0);
            ball.setySpeed(0);
        }

        //see if the ball hits the top or bottom wall 
        if(!(ball.getyPos() >= 10 && ball.getyPos() <= 400)){
            ball.setySpeed(-ball.getySpeed());
        }
        //see if the ball hits the left paddle
        
        if(ball.getxPos() <= leftPaddle.getxPos()+leftPaddle.getWidth()+Math.abs(ball.getxSpeed())
                &&
                (ball.getyPos() >= leftPaddle.getyPos() &&
                ball.getyPos() <= leftPaddle.getyPos() + leftPaddle.getHeight() || 
                ball.getyPos() + ball.getHeight() >= leftPaddle.getyPos() &&
                ball.getyPos() + ball.getHeight() < leftPaddle.getyPos()+leftPaddle.getHeight()
                ))
        {
            if(ball.getxPos() <=  leftPaddle.getxPos()+leftPaddle.getWidth()-Math.abs(ball.getxSpeed()))
            {
                 ball.setySpeed(-ball.getySpeed());
            }
            else
            {
                 ball.setxSpeed(-ball.getxSpeed());
            }
        }
                

        //see if the ball hits the right paddle
        
        if(ball.getxPos() >= rightPaddle.getxPos()+rightPaddle.getWidth()+Math.abs(ball.getxSpeed())
                &&
                (ball.getyPos() >= rightPaddle.getyPos() &&
                ball.getyPos() <= rightPaddle.getyPos() + rightPaddle.getHeight() || 
                ball.getyPos() + ball.getHeight() >= rightPaddle.getyPos() &&
                ball.getyPos() + ball.getHeight() < rightPaddle.getyPos()+rightPaddle.getHeight()
                ))
        {
            if(ball.getxPos() >=  rightPaddle.getxPos()+rightPaddle.getWidth()-Math.abs(ball.getxSpeed()))
            {
                 ball.setySpeed(-ball.getySpeed());
            }
            else
            {
                 ball.setxSpeed(-ball.getxSpeed());
            }
        }
        
        
        
        
        
        
        
        //see if the paddles need to be moved
          if (keys[0] == true) {
            leftPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[1] == true) {
            leftPaddle.moveDownAndDraw(graphToBack);
        }
        if (keys[2] == true) {
            rightPaddle.moveUpAndDraw(graphToBack);
        }
        if (keys[3] == true) {
            rightPaddle.moveDownAndDraw(graphToBack);
        }
        twoDGraph.drawImage(back, null, 0, 0);
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = true;
                break;
            case 'Z':
                keys[1] = true;
                break;
            case 'I':
                keys[2] = true;
                break;
            case 'M':
                keys[3] = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                keys[0] = false;
                break;
            case 'Z':
                keys[1] = false;
                break;
            case 'I':
                keys[2] = false;
                break;
            case 'M':
                keys[3] = false;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(8);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
