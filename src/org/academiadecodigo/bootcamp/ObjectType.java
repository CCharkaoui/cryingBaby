package org.academiadecodigo.bootcamp;

/**
 * Types of objects
 */

public enum ObjectType {
    DIAPER("diaper"),
    PACIFIER("pacifier"),
    CUBES("cubes"),
    TEDDY_BEAR("teddyBear"),
    FEEDER("feeder"),
    BROCCOLI("broccoli"),
    CLOWN("clown");

    private String type;

    ObjectType(String type) {
        this.type = type;
    }

    //This getter method will be used to get the respective object fileName
    public String objectTypeName() {
        return this.type;
    }

    /**
     * Generates Random Type of Object (60% Good Types and 40% Bad Types)
     *
     * @return ObjectType
     */

    public static ObjectType generateRandomType() {

        int probabilityOfObjectType = Randomizer.getRandom(100);

        if (probabilityOfObjectType < 60) {

            //random of good Types between Diaper and Feeder
            int randomGoodType = Randomizer.getRandom(4);
            return values()[randomGoodType];

        } else {

            //random of bad types between Broccoli and clown
            int randomBadType = Randomizer.getRandom(5, 6);
            return values()[randomBadType];
        }
    }

    public static ObjectType generateGoodType() {

        int random = Randomizer.getRandom(4);
        return values()[random];
    }
}
