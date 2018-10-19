package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * this class is responsible for the interaction between player, baby and objects
 */
public class Game implements KeyboardHandler {

    // Propertieso
    public final static int NUMBER_OF_OBJECTS = 6;
    private GameObjects[][] objectsPosition;
    private Keyboard keyboard;
    private Player player;
    private Baby baby;
    private int cols;
    private int rows;
    private Rectangle field;
    private Picture[][] fieldPictures;

    // Constructor
    public Game(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;

        field = new Rectangle(GameObjects.PADDING, GameObjects.PADDING, this.cols * GameObjects.CELL_SIZE, this.rows * GameObjects.CELL_SIZE);
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

        // Set game objects position
        objectsPosition = new GameObjects[rows][cols];
        objectsPosition[rows/2][cols/2] = new Baby(rows/2, cols/2);

        objectsPosition = ObjectFactory.createRandomObjects(this);



        // Player and keyboard setup
        player = new Player(0, 0, this);
        keyboard = new Keyboard(this);
        keyboardInit();
    }

    // Getters/setters
    public GameObjects[][] getObjectsPosition() {
        return objectsPosition;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:

                player.moveLeft();

                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
            case KeyboardEvent.KEY_RIGHT:
                player.moveRight();

                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
            case KeyboardEvent.KEY_UP:
                player.moveUp();
                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
            case KeyboardEvent.KEY_DOWN:
                player.moveDown();
                System.out.println("col " + player.getCol() + ". row " + player.getRow());
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}


