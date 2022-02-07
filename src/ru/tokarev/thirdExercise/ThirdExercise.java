package ru.tokarev.thirdExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Приложение состоит из класса WordList, где прописаны все необходимые методы, и вспомогательного класса Pair,
 * реализующий пару(кортеж)
 * **/

public class ThirdExercise {

    /** To run app just use FirstExercise.solution() method **/
    public static void solution (){

        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String[] words = bufferedReader.readLine().split(" ");

            WordList wordList = new WordList(words);
            wordList.sortArrayListByAmountOfVowels();
            wordList.printWordList();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
