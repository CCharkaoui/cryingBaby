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
        statusBarBackground();
        lifeIndicators();
        babyHappinessIndicators();
    }

    private void statusBarBackground() {
        barBackground = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.PADDING, "resources/barBackgroundPicture.png");
        barBackground.draw();
    }

    private void lifeIndicators() {

        lifeIndicator1 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.PADDING, "resources/playerLifeIndicator.png");
        lifeIndicator1.draw();

        lifeIndicator2 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.PADDING + Constants.CELL_SIZE, "resources/playerLifeIndicator.png");
        lifeIndicator2.draw();

        lifeIndicator3 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.PADDING + Constants.CELL_SIZE * 2, "resources/playerLifeIndicator.png");
        lifeIndicator3.draw();
    }

    private void babyHappinessIndicators() {

        babyHappinessIndicator1 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE * 3 + Constants.PADDING, "resources/babyHappinessIndicator.png");
        babyHappinessIndicator1.draw();

        babyHappinessIndicator2 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE * 2 + Constants.PADDING, "resources/babyHappinessIndicator.png");
        babyHappinessIndicator2.draw();

        babyHappinessIndicator3 = new Picture(Constants.COLS * Constants.CELL_SIZE + Constants.PADDING * 2, Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE + Constants.PADDING, "resources/babyHappinessIndicator.png");
        babyHappinessIndicator3.draw();
    }
}
