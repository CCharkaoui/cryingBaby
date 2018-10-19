package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {

    private Position[][] cells;
    private Keyboard keyboard;
    private Player player;
    private int cols;
    private int rows;
    private Rectangle field;
    private Picture[][] fieldPictures;

    public Game(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;

        field = new Rectangle(Position.PADDING, Position.PADDING, this.cols * Position.CELL_SIZE, this.rows * Position.CELL_SIZE);
        field.setColor(Color.BLACK);
        field.draw();

        fieldPictures = new Picture[3][5];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                fieldPictures[row][col] = new Picture(col * Position.CELL_SIZE * 4 + Position.PADDING, row * Position.CELL_SIZE * 4 + Position.PADDING, "resources/floor.png");
                fieldPictures[row][col].draw();
            }
        }


        //fieldPicture = new Picture(0, 0"resources/floor.png");
        //fieldPicture.draw();

        cells = new Position[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Position(col, row);
            }
        }


        player = new Player(0, 0, this);
        keyboard = new Keyboard(this);

        keyboardInit();

    }

    public Position[][] getCells() {
        return cells;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

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


