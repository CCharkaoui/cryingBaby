package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends GameObjects {

    //properties
    private Picture playerPicture;
    private int col;
    private int row;

    //constructor
    public Player(int row, int col) {
        super(col, row);
        this.col = col;
        this.row = row;
        playerPicture = new Picture(getRectangle().getX(), getRectangle().getY(), "resources/front.png");
        playerPicture.draw();
    }

    //getters & setters
    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    //methods
    public void moveLeft() {
        if (col > 0) {
            this.playerPicture.load("resources/left.png");
            this.playerPicture.translate(-CELL_SIZE, 0);
            --col;
        }
    }

    public void moveRight() {

        if (col < Game.COLS - 1) {
            this.playerPicture.load("resources/right.png");
            this.playerPicture.translate(CELL_SIZE, 0);
            ++col;
        }
    }

    public void moveUp() {

        if (row > 0) {
            this.playerPicture.load("resources/back.png");
            this.playerPicture.translate(0, -CELL_SIZE);
            --row;
        }
    }

    public void moveDown() {

        if (row < Game.ROWS - 1) {
            this.playerPicture.load("resources/front.png");
            this.playerPicture.translate(0, CELL_SIZE);
            ++row;
        }
    }


}
