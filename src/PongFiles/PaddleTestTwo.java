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

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable {

    private Ball ball;
    private Paddle leftPaddle;
    private boolean[] keys;		//keeps track of what keys are pressed

    public PaddleTestTwo() {
		//set up all game variables

		//instantiate a Ball
        //instantiate a left Paddle
        //instantiate a right Paddle
        keys = new boolean[5];

        //set up the Canvas
        setBackground(Color.WHITE);
        setVisible(true);

        this.addKeyListener(this);
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        ball.moveAndDraw(window);
        leftPaddle.draw(window);

        if (!(ball.getxSpeed() >= 10 && ball.getxSpeed() <= 550)) {
            ball.setxSpeed(-ball.getxSpeed());
        }

        if (!(ball.getyPos() >= 10 && ball.getyPos() <= 450)) {
            ball.setySpeed(-ball.getySpeed());
        }

        if (keys[0] == true) {
            //move left paddle up and draw it on the window
            leftPaddle.moveUpAndDraw(window);
        }
        if (keys[1] == true) {
            //move left paddle down and draw it on the window

        }
        if (keys[2] == true) {

        }
        if (keys[3] == true) {

        }
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
        //no code needed here
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
