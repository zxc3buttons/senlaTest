package ru.tokarev.firstExercise;

public class NumberSumService {
    private char[] numberSymbols;

    public NumberSumService(String numberString) {
        numberSymbols = numberString.toCharArray();
    }

    public int getSum() {

        int sum = 0;
        for (char c : numberSymbols) {
            if (c >= 48 && c <= 57)
                sum += c - 48;
        }

        return sum;
    }

}
