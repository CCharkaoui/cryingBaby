package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameOver {

    // Properties
    private Rectangle field;
    private Picture[][] fieldPictures;
    private Picture madMotherEnding, happyMotherEnding;
    private Picture badEndingLetters, goodEndingLetters;
    private boolean goodEndType;

    // Constructor
    public GameOver(boolean endType) {

        this.goodEndType = endType;

        menuBackgroundGenerator();
        gameOverMotherType();
    }

    // Methods
    private void menuBackgroundGenerator() {
        // Everything needed to draw the menu background (same logic that we have in Game class to create the field
        field = new Rectangle(Constants.PADDING, Constants.PADDING, Constants.COLS * Constants.CELL_SIZE, Constants.ROWS * Constants.CELL_SIZE);
        field.setColor(Color.BLACK);
        field.draw();

        fieldPictures = new Picture[3][5];
        // Draws field
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                fieldPictures[row][col] = new Picture(col * Constants.CELL_SIZE * 4 + Constants.PADDING, row * Constants.CELL_SIZE * 4 + Constants.PADDING, "resources/floor.png");
                fieldPictures[row][col].draw();
            }
        }
    }

    private void gameOverMotherType() {

        if (this.goodEndType) {
            // Good ending
            goodEndingLetters = new Picture(Constants.PADDING + Constants.CELL_SIZE * Constants.COLS / 3, Constants.PADDING + Constants.CELL_SIZE * 2, "resources/goodEnding.png");
            goodEndingLetters.draw();
            happyMotherEnding = new Picture(Constants.PADDING + Constants.CELL_SIZE * Constants.COLS / 2, Constants.PADDING + Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE * 3.35, "resources/happyMotherGameOver.png");
            happyMotherEnding.draw();
            return;

        }
        // Bad ending
        badEndingLetters = new Picture(Constants.PADDING + Constants.CELL_SIZE * Constants.COLS / 3.5, Constants.PADDING + Constants.CELL_SIZE * 2, "resources/badEnding.png");
        badEndingLetters.draw();
        madMotherEnding = new Picture(Constants.PADDING + Constants.CELL_SIZE * Constants.COLS / 2, Constants.PADDING + Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE * 3.75, "resources/madMotherGameOver.png");
        madMotherEnding.draw();
    }
}
