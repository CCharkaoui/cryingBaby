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
    public final static int MAX_NUMBER_OF_OBJECTS = 6;
    public final static int COLS = 20;
    public final static int ROWS = 12;
    private GameObjects[][] objectsPosition;
    private Keyboard keyboard;
    private Player player;
    private Baby baby;
    private Rectangle field;
    private Picture[][] fieldPictures;
    private int numberPictures = 0;

    // Constructor
    public Game() {

        field = new Rectangle(GameObjects.PADDING, GameObjects.PADDING, COLS * GameObjects.CELL_SIZE, ROWS * GameObjects.CELL_SIZE);
        field.setColor(Color.BLACK);
        field.draw();

        fieldPictures = new Picture[3][5];

        // Draws field
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                fieldPictures[row][col] = new Picture(col * GameObjects.CELL_SIZE * 4 + GameObjects.PADDING, row * GameObjects.CELL_SIZE * 4 + GameObjects.PADDING, "resources/floor.png");
                fieldPictures[row][col].draw();
            }
        }

        // Player and keyboard setup
        player = new Player(0, 0);

        // Set game objects position
        objectsPosition = new GameObjects[ROWS][COLS];
        objectsPosition[ROWS / 2][COLS / 2] = new Baby(ROWS / 2, COLS / 2);

        objectsPosition = ObjectFactory.createRandomObjects(this);


        keyboard = new Keyboard(this);
        keyboardInit();

    }

    // Getters/setters
    public GameObjects[][] getObjectsPosition() {
        return objectsPosition;
    }

    public Player getPlayer() {
        return player;
    }

    public int getNumberPictures() {
        return numberPictures;
    }

    public void changeNumberPictures(int numberPictures) {
        this.numberPictures = numberPictures;
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

        KeyboardEvent fillColor = new KeyboardEvent();
        fillColor.setKey(KeyboardEvent.KEY_SPACE);
        fillColor.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKey(KeyboardEvent.KEY_C);
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
    }

    public void checkObject() {

            if (objectsPosition[player.getRow()][player.getCol()] != null) {

                ((Object)objectsPosition[player.getRow()][player.getCol()]).getObjectPicture().delete();
                ObjectFactory.createRandomObjects(this);

            }

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                player.moveLeft();
                checkObject();

                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();
                checkObject();

                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
            case KeyboardEvent.KEY_UP:
                player.moveUp();
                checkObject();
                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
            case KeyboardEvent.KEY_DOWN:
                player.moveDown();
                checkObject();
                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


