package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Position {

    private Picture playerPicture;
    private Game game;
    private int col;
    private int row;

    public Player(int col, int row, Game game) {
        super(col, row);
        this.col = col;
        this.row = row;
        this.game = game;
        playerPicture = new Picture(getRectangle().getX(), getRectangle().getY(), "resources/front.png");
        playerPicture.draw();
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
            this.playerPicture.load("resources/left.png");
            this.playerPicture.translate(-getCellSize(), 0);
            --col;
        }
    }

    public void moveRight() {

        if (col < game.getCols() - 1) {
            this.playerPicture.load("resources/right.png");
            this.playerPicture.translate(getCellSize(), 0);
            ++col;
        }
    }

    public void moveUp() {

        if (row > 0) {
            this.playerPicture.load("resources/back.png");
            this.playerPicture.translate(0, -getCellSize());
            --row;
        }
    }

    public void moveDown() {

        if (row < game.getRows() - 1) {
            this.playerPicture.load("resources/front.png");
            this.playerPicture.translate(0, getCellSize());
            ++row;
        }
    }


}
