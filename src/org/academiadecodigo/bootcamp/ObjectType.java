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

    public static String getRandomObject() {


        // The probability (%) of choosing each enemy type
        int probabilityOfObjectType = Randomizer.getRandom(100);

        if (probabilityOfObjectType < 60) {

            int randomGoodType = Randomizer.getRandom(4);
            return values()[randomGoodType].type;

        } else {

            int randomBadType = Randomizer.getRandom(5, 6);
            return values()[randomBadType].type;
        }





    }

}
