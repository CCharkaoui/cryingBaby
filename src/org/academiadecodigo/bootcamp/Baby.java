package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Baby extends GameObjects {

    // Properties
    private Picture babyPicture;
    private boolean crying;


    // constructor
    public Baby(int col, int row) {
        super(col, row);
        this.crying = false;
        babyPicture = new Picture(getRectangle().getX(), getRectangle().getY(), "resources/babyNormal.png");
        babyPicture.draw();
    }


    // Getters/setters
    public boolean isCrying() {
        return crying;
    }

    public void cry(boolean state) {
        this.crying = state;
    }

    // Methods
}

