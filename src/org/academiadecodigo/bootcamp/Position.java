package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    public static final int PADDING = 10;
    public static final int CELL_SIZE = 64;
    private int col = 0;
    private int row = 0;
    private int x;
    private int y;
    private Rectangle rectangle;

    public Position(int col, int row) {


        x = PADDING + CELL_SIZE * row;
        y = PADDING + CELL_SIZE * col;

        rectangle = new Rectangle(x, y, CELL_SIZE, CELL_SIZE);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getCellSize() {
        return CELL_SIZE;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}


