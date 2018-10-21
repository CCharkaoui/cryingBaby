package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameInstructions implements KeyboardHandler {

    // Properties
    private Rectangle field;
    private Picture[][] fieldPictures;
    private Picture instructions, goBackBtn;

    // constructor
    public GameInstructions() {
        instructionsMenu();

        // p - to start the game
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent goBack = new KeyboardEvent();
        goBack.setKey(KeyboardEvent.KEY_B);
        goBack.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(goBack);
    }

    // Methods
    private void instructionsMenu() {
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

        // Instructions
        instructions = new Picture(Constants.PADDING + Constants.CELL_SIZE * Constants.COLS / 4, Constants.PADDING + Constants.CELL_SIZE * Constants.ROWS / 4, "resources/instructionText.png");
        instructions.draw();
        goBackBtn = new Picture(Constants.PADDING + Constants.CELL_SIZE * Constants.COLS / 8, Constants.PADDING + Constants.CELL_SIZE * Constants.ROWS - Constants.CELL_SIZE * 1.5, "resources/goBackBtn.png");
        goBackBtn.draw();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_B:
                GameInitialMenu gameInitialMenu = new GameInitialMenu();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
