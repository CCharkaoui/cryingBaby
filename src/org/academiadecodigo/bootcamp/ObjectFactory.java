package org.academiadecodigo.bootcamp;

public class ObjectFactory {

    /**
     * Creates ramdomly up to 6 objects
     * @param game
     * @return
     */


    public static GameObjects[][] createRandomObjects(Game game) {


        GameObjects[][] temp = new GameObjects[game.getRows()][game.getCols()];

        for (int numberObjects = 0; numberObjects < Game.NUMBER_OF_OBJECTS; numberObjects++) {

            int rowRandom = Randomizer.getRandom(game.getRows() - 1);
            int colRandom = Randomizer.getRandom(game.getCols() - 1);
            System.out.println(game.getRows());
            System.out.println(game.getCols());
            if (temp[rowRandom][colRandom] == null) {
                temp[rowRandom][colRandom] = new Object(rowRandom, colRandom);
            }

        }

        return temp;
    }

}

