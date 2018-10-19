package org.academiadecodigo.bootcamp;

public class ObjectFactory {

    /**
     * Generates ramdomly up to 6 objects
     * @param game
     * @return GameObjects[][]
     */


    public static GameObjects[][] createRandomObjects(Game game) {

    //TO DO: PUT THIS WORKING WELL!!!!! WHILE AN OBJECT IS ELIMINATED CREATES ALWAYS NEW OBJECTS UP TO MAX

        GameObjects[][] temp = new GameObjects[Game.ROWS][Game.COLS];
        //while (game.getNumberPictures() )
        for (int numberObjects = 0; numberObjects < Game.MAX_NUMBER_OF_OBJECTS; ) {

            int rowRandom = Randomizer.getRandom(Game.ROWS - 1);
            int colRandom = Randomizer.getRandom(Game.COLS - 1);

            //Generate a new Object if the position in game is empty
            if (temp[rowRandom][colRandom] == null && game.getPlayer().getCol()
                    != colRandom && game.getPlayer().getRow() != rowRandom) {

                temp[rowRandom][colRandom] = new Object(rowRandom, colRandom);
                ++numberObjects;
                //game.changeNumberPictures();
            }

        }

        return temp;
    }

}

