package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Object extends GameObjects {

    //properties
    private Picture objectPicture;

    //constructor
    public Object(int row, int col) {
        super(row, col);

        objectPicture = new Picture(getRectangle().getX(),getRectangle().getY()
                , "resources/" + ObjectType.generateRandomObject() + ".png");
        objectPicture.draw();
    }

    //getters & setters


    public Picture getObjectPicture() {
        return objectPicture;
    }
}
