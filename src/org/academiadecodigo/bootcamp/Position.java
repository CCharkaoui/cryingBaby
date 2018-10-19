package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    public static final int PADDING = 10;
    private int cellSize = 20;
    private Color color;
    private int col = 0;
    private int row = 0;
    private int x;
    private int y;
    private Rectangle rectangle;

    public Position(int col, int row) {


        x = PADDING + cellSize*row;
        y = PADDING + cellSize*col;

        rectangle = new Rectangle(x,y,cellSize,cellSize);
        rectangle.setColor(Color.BLACK);
        rectangle.draw();



    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {

        if (rectangle.isFilled()) {
            return "b";

        }
        return "w";
    }
}


