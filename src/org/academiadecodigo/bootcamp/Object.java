package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Object extends GameObjects {

    //properties
    private Picture objectPicture;

    //constructor
    public Object(int col, int row) {
        super(col, row);

        objectPicture = new Picture(getRectangle().getX(),getRectangle().getY()
                , "resources/" + ObjectType.generateRandomObject() + ".png");
        objectPicture.draw();
    }


}
