package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * This class is responsible for the interaction between player, baby and objects
 */
public class Game implements KeyboardHandler {

    // Properties
    private GameObjects[][] objectsPosition;
    private Keyboard keyboard;
    private Player player;
    private Baby baby;
    private Rectangle field;
    private Picture[][] fieldPictures;
    private PlayerStatusBar playerStatusBar;

    // Constructor
    public Game() {

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

        // Player and keyboard setup
        player = new Player(0, 0);
        keyboard = new Keyboard(this);
        keyboardInit();

        // Set game objects position
        objectsPosition = new GameObjects[Constants.ROWS][Constants.COLS];
        this.baby = new Baby(Constants.ROWS / 2, Constants.COLS / 2);
        objectsPosition[Constants.ROWS / 2][Constants.COLS / 2] = baby;

        objectsPosition = ObjectFactory.createRandomObjects(this, Constants.MAX_NUMBER_OF_OBJECTS);

        // Player Status Bar
        playerStatusBar = new PlayerStatusBar();
    }

    // Getters/setters
    public GameObjects[][] getObjectsPosition() {
        return objectsPosition;
    }

    public Player getPlayer() {
        return player;
    }

    // Methods


    //  keyboard events
    public void keyboardInit() {


        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
    }

    //check if the player is in the position of an object and if so eliminates the picture
    private void checkObject() {

        if (objectsPosition[player.getRow()][player.getCol()] != null) {

            ((Object) objectsPosition[player.getRow()][player.getCol()]).getObjectPicture().delete();
            createRandomObject();

        }

    }


    //Generate a new Object if the position in game is empty
    private void createRandomObject() {

        int rowRandom = Randomizer.getRandom(Constants.ROWS - 1);
        int colRandom = Randomizer.getRandom(Constants.COLS - 1);

        if (objectsPosition[rowRandom][colRandom] == null && player.getCol()
                != colRandom && player.getRow() != rowRandom) {

            objectsPosition[rowRandom][colRandom] = new Object(rowRandom, colRandom);
        }
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                if (!(player.getCol() - 1 == baby.getCol() && player.getRow() == baby.getRow())) {
                    player.moveLeft();
                    checkObject();
                }

                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;

            case KeyboardEvent.KEY_RIGHT:

                if (!(player.getCol() + 1 == baby.getCol() && player.getRow() == baby.getRow())) {
                    player.moveRight();
                    checkObject();
                }

                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;

            case KeyboardEvent.KEY_UP:

                if (!(player.getCol() == baby.getCol() && player.getRow() - 1 == baby.getRow())) {
                    player.moveUp();
                    checkObject();
                }

                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;

            case KeyboardEvent.KEY_DOWN:

                if (!(player.getCol() == baby.getCol() && player.getRow() + 1 == baby.getRow())) {
                    player.moveDown();
                    checkObject();
                }

                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


