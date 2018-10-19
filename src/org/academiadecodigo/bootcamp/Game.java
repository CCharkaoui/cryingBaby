package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Game implements KeyboardHandler {

    private Position[][] grid;
    private Keyboard keyboard;
    private Player player;
    private int cols;
    private int rows;

    public Game(int cols, int rows) {

        this.cols = cols;
        this.rows = rows;


        grid = new Position[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = new Position(col, row);
            }
        }

        player = new Player(0,0, this);
        keyboard = new Keyboard(this);

        init();

    }

    public Position[][] getGrid() {
        return grid;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public void init() {


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
        keyboard.addEventListener(fillColor);
        keyboard.addEventListener(clear);
        keyboard.addEventListener(save);

    }

    public void paint() {

        if (!grid[player.getCol()][player.getRow()].getRectangle().isFilled()) {
            grid[player.getCol()][player.getRow()].getRectangle().setColor(Color.BLACK);
            grid[player.getCol()][player.getRow()].getRectangle().fill();
            return;
        }

        grid[player.getCol()][player.getRow()].getRectangle().setColor(Color.WHITE);
        grid[player.getCol()][player.getRow()].getRectangle().fill();
        grid[player.getCol()][player.getRow()].getRectangle().setColor(Color.BLACK);

        grid[player.getCol()][player.getRow()].getRectangle().draw();

    }

    public void clear() {

        for (int row = 0; row  < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col].getRectangle().setColor(Color.BLACK);
                grid[row][col].getRectangle().draw();
            }
        }
    }

    public void save() {

        FileWriter writer = null;
        try {
            writer = new FileWriter("resources/temp.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bWriter = new BufferedWriter(writer);

        try {
            bWriter.write(grid.toString());
            bWriter.flush();
            bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


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

            case KeyboardEvent.KEY_SPACE:
                paint();
                break;

            case KeyboardEvent.KEY_C:
                clear();
                break;

            case KeyboardEvent.KEY_S:
                save();
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    @Override
    public String toString() {

        String temp = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                temp += grid[row][col].toString();
            }
            temp += "\n";
        }
        return temp;
    }
}


