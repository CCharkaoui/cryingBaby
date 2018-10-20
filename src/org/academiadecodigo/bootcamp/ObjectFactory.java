package org.academiadecodigo.bootcamp;

public class ObjectFactory {

    /**
     * Generates randomly a fixed number of objects in game
     * @param game
     * @param numberObjects
     * @return GameObjects[][]
     */

    public static GameObjects[][] createRandomObjects(Game game, int numberObjects) {

        GameObjects[][] temp = new GameObjects[Constants.ROWS][Constants.COLS];

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

