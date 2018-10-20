package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Superclass GameObjects
 */

public class GameObjects {

    //properties
    private int col = 0;
    private int row = 0;
    private Rectangle rectangle;

    //constructor
    public GameObjects(int row, int col) {


        rectangle = new Rectangle(colToX(col), rowToY(row), Constants.CELL_SIZE, Constants.CELL_SIZE);
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

    private int rowToY(int row) {

        int y = Constants.PADDING + Constants.CELL_SIZE * row;

        return y;
    }

    private int colToX(int col) {

        int x = Constants.PADDING + Constants.CELL_SIZE * col;

        return x;
    }
}


