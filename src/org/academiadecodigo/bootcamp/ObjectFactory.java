package org.academiadecodigo.bootcamp;

public class ObjectFactory {

    /**
     * Generates randomly a fixed number of objects in game
     *
     * @param game
     * @param numberObjects
     * @return GameObjects[][]
     */

    public static GameObjects[][] createObjects(Game game, int numberObjects) {

        GameObjects[][] temp = game.getObjectsPosition();

        //Generate one object of each type
        for (int i = 0; i < ObjectType.values().length; i++) {

            int rowRandom = Randomizer.getRandom(Constants.ROWS - 1);
            int colRandom = Randomizer.getRandom(Constants.COLS - 1);

            if (temp[rowRandom][colRandom] == null && game.getPlayer().getCol()
                    != colRandom && game.getPlayer().getRow() != rowRandom) {

                temp[rowRandom][colRandom] = new Object(rowRandom, colRandom, ObjectType.values()[i]);
                --numberObjects;


            }
        }

        //Generate objects of a random type
        while (numberObjects > 0) {

            int rowRandom = Randomizer.getRandom(Constants.ROWS - 1);
            int colRandom = Randomizer.getRandom(Constants.COLS - 1);

            //Generate a new Object if the position in game is empty
            if (temp[rowRandom][colRandom] == null && game.getPlayer().getCol()
                    != colRandom && game.getPlayer().getRow() != rowRandom) {

                temp[rowRandom][colRandom] = new Object(rowRandom, colRandom);
                --numberObjects;
            }

        }

        return temp;
    }
}

