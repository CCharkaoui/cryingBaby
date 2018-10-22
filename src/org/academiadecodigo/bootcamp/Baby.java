package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Baby extends GameObjects {

    // Properties
    private Picture babyPicture;
    private boolean crying;
    private int col;
    private int row;
    private ObjectType babyNeed;


    // constructor
    public Baby(int row, int col) {
        super(row, col);
        this.col = col;
        this.row = row;
        this.crying = false;
        babyNeed = ObjectType.generateGoodType();
        babyPicture = new Picture(getRectangle().getX(), getRectangle().getY(), "resources/babycrying64.png");
        babyPicture.draw();
    }


    // Getters/setters
    public boolean isCrying() {
        return crying;
    }

    public void cry(boolean state) {
        this.crying = state;
    }

    public Picture getBabyPicture() {
        return babyPicture;
    }

    public void newBabyNeed() {
        this.babyNeed = ObjectType.generateGoodType();
    }

    public ObjectType getBabyNeed() {
        return babyNeed;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    // Methods
}

