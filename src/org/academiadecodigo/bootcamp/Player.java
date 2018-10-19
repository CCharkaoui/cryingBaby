package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Player extends Position {


    private Game game;
    private int col;
    private int row;

    public Player(int col, int row, Game game) {
        super(col,row);
        this.col = col;
        this.row = row;
        this.game = game;
        getRectangle().setColor(Color.GREEN);
        getRectangle().draw();
        getRectangle().fill();

    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    public void moveLeft() {
        if (col > 0) {
            getRectangle().translate(-getCellSize(), 0);
            --col;
        }
    }

    public void moveRight() {

        if (col < game.getCols()-1) {
            getRectangle().translate(getCellSize(), 0);
            ++col;
        }
    }

    public void moveUp() {

        if (row > 0) {
            getRectangle().translate(0, -getCellSize());
            --row;
        }
    }

    public void moveDown() {

        if (row < game.getRows()-1) {
            getRectangle().translate(0, getCellSize());
            ++row;
        }
    }










}
