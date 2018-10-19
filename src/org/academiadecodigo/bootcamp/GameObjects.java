package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Superclass GameObjects
 */

public class GameObjects {

    //properties
    public static final int PADDING = 10;
    public static final int CELL_SIZE = 64;
    private int col = 0;
    private int row = 0;
    private int x;
    private int y;
    private Rectangle rectangle;

    //constructor
    public GameObjects(int col, int row) {


        x = PADDING + CELL_SIZE * row;
        y = PADDING + CELL_SIZE * col;

        rectangle = new Rectangle(x, y, CELL_SIZE, CELL_SIZE);
    }


    //getters & setters
    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}


