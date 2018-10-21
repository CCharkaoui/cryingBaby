package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameInitialMenu implements KeyboardHandler {

    // Properties
    private Rectangle field;
    private Picture[][] fieldPictures;
    private Picture menuLettersLogo, startBtn, babyLogo, fatherLogo, motherLogo;

    // Constructor
    public GameInitialMenu() {

        // menu contents
        menuBackgroundGenerator();
        menuForegroundGenerator();

        // p - to start the game
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent pStart = new KeyboardEvent();
        pStart.setKey(KeyboardEvent.KEY_P);
        pStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pStart);
    }

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

    private void menuForegroundGenerator() {
        menuLettersLogo = new Picture(Constants.PADDING * Constants.COLS / 2, Constants.PADDING * Constants.ROWS - Constants.CELL_SIZE, "resources/cryingBabyLettersLogo.png");
        babyLogo = new Picture(Constants.PADDING * Constants.COLS * 2.5, Constants.PADDING * Constants.ROWS + Constants.CELL_SIZE * 3, "resources/cryingBabyMenuLogo.png");
        fatherLogo = new Picture(0, Constants.PADDING * Constants.ROWS + Constants.CELL_SIZE - 35, "resources/scaredFather.png");
        motherLogo = new Picture(Constants.PADDING * Constants.COLS + Constants.CELL_SIZE * 6.8, Constants.PADDING * Constants.ROWS + Constants.CELL_SIZE - 18, "resources/madMother.png");
        startBtn = new Picture(Constants.PADDING + Constants.CELL_SIZE * Constants.COLS / 3, 0, "resources/startBtn.png");

        // Order of pictures appearance
        menuLettersLogo.draw();
        fatherLogo.draw();
        motherLogo.draw();
        babyLogo.draw();
        startBtn.draw();
    }

    private void deleteMenu() {
        menuLettersLogo.delete();
        fatherLogo.delete();
        motherLogo.delete();
        babyLogo.delete();
        startBtn.delete();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_P:
                // Delete the menu contents
                deleteMenu();
                // start the game itself
                Game game = new Game();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
