package ru.tokarev.thirdExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public class WordList {

    private final ArrayList<Pair<String, Integer>> list;
    private final HashSet<Character> vowels;

    public WordList(String[] words) {

        Character[] arrayOfVowels = {'А', 'И', 'Е', 'Ё', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я',
                'а', 'и', 'у', 'ё', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        vowels = new HashSet<>(Arrays.asList(arrayOfVowels));

        list = new ArrayList<>();
        for (String word : words) {
            list.add(new Pair<>(word, countVowels(word)));
        }

    }

    public int countVowels(String word) {

        int amountOfVowels = 0;
        for(int i = 0; i < word.length(); i++)
            if(vowels.contains(word.charAt(i)))
                amountOfVowels++;

        return amountOfVowels;
    }

    public void sortArrayListByAmountOfVowels() {
        list.sort((o1, o2) -> o2.second - o1.second);
    }

    public void printWordList() {

        for(Pair<String, Integer> pair: list){
            String currentWord = pair.first;

            for(int i = 0; i < currentWord.length(); i++) {
                if(vowels.contains(currentWord.charAt(i))){
                    String symbolToUpperCase;
                    if(i != currentWord.length() - 1)
                        symbolToUpperCase = currentWord.substring(i, i + 1).toUpperCase(Locale.ROOT);
                    else
                        symbolToUpperCase = currentWord.substring(i).toUpperCase(Locale.ROOT);
                    if(i == 0)
                        currentWord = symbolToUpperCase + currentWord.substring(1);
                    else if(i == currentWord.length() - 1)
                        currentWord = currentWord.substring(0, i) + symbolToUpperCase;
                    else
                        currentWord = currentWord.substring(0, i) + symbolToUpperCase + currentWord.substring(i+1);
                    break;
                }
            }
            System.out.println(currentWord);
        }
    }
}
