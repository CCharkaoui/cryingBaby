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

    /**
     * Generates Random Objects (60% Good Types and 40% Bad Types)
     * @return objectFileName
     */

    public static String generateRandomObject() {


        // The probability (%) of choosing each enemy type
        int probabilityOfObjectType = Randomizer.getRandom(100);

        if (probabilityOfObjectType < 60) {

            //random of good Types between Diaper and Feeder
            int randomGoodType = Randomizer.getRandom(4);
            return values()[randomGoodType].type;

        } else {

            //random of bad types between Broccoli and clown
            int randomBadType = Randomizer.getRandom(5, 6);
            return values()[randomBadType].type;
        }





    }

}
