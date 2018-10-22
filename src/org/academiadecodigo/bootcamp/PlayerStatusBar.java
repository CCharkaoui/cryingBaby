package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PlayerStatusBar {

    // Properties
    private Picture barBackground;
    private Picture lifeIndicator1, lifeIndicator2, lifeIndicator3;
    private Picture babyHappinessIndicator1, babyHappinessIndicator2, babyHappinessIndicator3;

    // Constructor
    public PlayerStatusBar() {
        //statusBarBackground();
        lifeIndicators();
        babyHappinessIndicators();
    }

    //Draw a number of Happiness indicators depending on the player status
    public void scoreGoodIndicators (int playerCorrectGuesses) {

        switch (playerCorrectGuesses) {

            case 1:
                babyHappinessIndicator1.draw();
                break;

            case 2:
                babyHappinessIndicator2.draw();
                break;

            case 3:
                babyHappinessIndicator3.draw();
                break;
        }
    }

    //Delete a life indicator from player status bar for each player wrong guess
    public void scoreBadIndicators (int playerWrongGuesses) {

        switch (playerWrongGuesses) {

            case 1:
                lifeIndicator3.delete();
                break;

            case 2:
                lifeIndicator2.delete();
                break;

            case 3:
                lifeIndicator1.delete();
                break;
        }
    }


    /**private void statusBarBackground() {
        barBackground = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.PADDING, "resources/barBackgroundPicture.png");
        barBackground.draw();
    }*/

    private void lifeIndicators() {

        lifeIndicator1 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.PADDING, "resources/front.png");
        lifeIndicator1.draw();

        lifeIndicator2 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.PADDING + Constants.CELL_SIZE, "resources/front.png");
        lifeIndicator2.draw();

        lifeIndicator3 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.PADDING + Constants.CELL_SIZE * 2, "resources/front.png");
        lifeIndicator3.draw();
    }

    private void babyHappinessIndicators() {

        babyHappinessIndicator1 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE * 3 + Constants.PADDING, "resources/babyHappinessIndicator.png");

        babyHappinessIndicator2 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE * 2 + Constants.PADDING, "resources/babyHappinessIndicator.png");

        babyHappinessIndicator3 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE + Constants.PADDING, "resources/babyHappinessIndicator.png");
    }
}
