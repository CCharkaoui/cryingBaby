package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Object extends GameObjects {

    private Picture objectPicture;


    public Object(int col, int row) {
        super(col, row);

        objectPicture = new Picture(getRectangle().getX(),getRectangle().getY()
                , "resources/" + ObjectType.getRandomObject() + ".png");
        objectPicture.draw();
    }


}
