package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Object extends GameObjects {

    //properties
    private Picture objectPicture;
    private ObjectType type;

    //constructors

    //generate an object from a random type
    public Object(int row, int col) {
        super(row, col);

        type = ObjectType.generateRandomType();

        objectPicture = new Picture(getRectangle().getX(), getRectangle().getY()
                , "resources/" + type.objectTypeName() + ".png");
        objectPicture.draw();
    }

    //generate an object from a specific type
    public Object(int row, int col, ObjectType type) {
        super(row, col);

        this.type = type;

        objectPicture = new Picture(getRectangle().getX(), getRectangle().getY()
                , "resources/" + type.objectTypeName() + ".png");
        objectPicture.draw();
    }


    //getters & setters


    public Picture getObjectPicture() {
        return objectPicture;
    }

    public ObjectType getType() {
        return type;
    }
}
