package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Superclass GameObjects
 */

public class GameObjects {

    //properties
    private int col;
    private int row;
    private Rectangle rectangle;

    //constructor
    public GameObjects(int row, int col) {

        this.col = col;
        this.row = row;

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

    public int rowToY(int row) {

        int y = Constants.PADDING + Constants.CELL_SIZE * row;

        return y;
    }

    public int colToX(int col) {

        int x = Constants.PADDING + Constants.CELL_SIZE * col;

        return x;
    }

}


