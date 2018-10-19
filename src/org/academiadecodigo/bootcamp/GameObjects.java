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
    private Rectangle rectangle;

    //constructor
    public GameObjects(int row, int col) {


        rectangle = new Rectangle(colToX(col), rowToY(row), CELL_SIZE, CELL_SIZE);
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

    private int rowToY (int row) {

        int y = PADDING + CELL_SIZE * row;

        return y;
    }

    private int colToX (int col) {

        int x = PADDING + CELL_SIZE * col;

        return x;
    }
}


