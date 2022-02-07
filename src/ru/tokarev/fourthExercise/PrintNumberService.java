package ru.tokarev.fourthExercise;

public class PrintNumberService {
    private final String[][] starSymbolCollection = {
            {" *** ", "  *  ", " *** ", "*****", "   * ", "*****", "*****", "*****", " *** ", " ****", "  "},
            {"*   *", " **  ", "*   *", "    *", "  ** ", "*    ", "*    ", "    *", "*   *", "*   *", "  "},
            {"*   *", "  *  ", "*   *", "    *", " * * ", "*    ", "*    ", "   * ", "*   *", "*   *", "  "},
            {"*   *", "  *  ", "   * ", "*****", "*  * ", "*****", "*****", "  *  ", " *** ", " ****", "  "},
            {"*   *", "  *  ", "  *  ", "    *", "*****", "    *", "*   *", " *   ", "*   *", "    *", "  "},
            {"*   *", "  *  ", " *   ",  "    *", "   * ", "    *", "*   *", "*    ", "*   *", "    *", "**"},
            {" *** ", " *** ", "*****", "*****", "   * ", "*****", "*****", "*    ", " *** ", "    *", "**"}
    };
    private final String[][] digitSymbolCollection = {
            {" 000 ", "  1  ", " 222 ", "33333", "   4 ", "55555", "66666", "77777", " 888 ", " 9999"},
            {"0   0", " 11  ", "2   2", "    3", "  44 ", "5    ", "6    ", "    7", "8   8", "9   9"},
            {"0   0", "  1  ", "2   2", "    3", " 4 4 ", "5    ", "6    ", "   7 ", "8   8", "9   9"},
            {"0   0", "  1  ", "   2 ", "33333", "4  4 ", "55555", "66666", "  7  ", " 888 ", " 9999"},
            {"0   0", "  1  ", "  2  ", "    3", "44444", "    5", "6   6", " 7   ", "8   8", "    9"},
            {"0   0", "  1  ", " 2   ",  "    3", "   4 ", "    5", "6   6", "7    ", "8   8", "    9"},
            {" 000 ", " 111 ", "22222", "33333", "   4 ", "55555", "66666", "7    ", " 888 ", "    9"}
    };

    private final char[] symbolsFromNumber;

    public PrintNumberService(String number) {
        symbolsFromNumber = stringNumberToChar(number);
    }

    private char[] stringNumberToChar(String number) {
        StringBuilder digitsOrPoint = new StringBuilder();

        for(int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == 46 ) {
                if(i != number.length() - 1) {
                    if(number.charAt(i + 1) != 46)
                        digitsOrPoint.append(number.charAt(i));
                    else {
                        System.out.println("Число не может содержать два знака '.'");
                        return null;
                    }
                }
            }
            else
                if(number.charAt(i) >= 48 && number.charAt(i) <= 57)
                    digitsOrPoint.append(number.charAt(i));
        }

        return digitsOrPoint.toString().toCharArray();
    }

    private int findMax(char[] array) {
        int max = 0;
        for(char sym: array)
            if(sym - 48 > max) max = sym - 48;

        return max;
    }

    public void printNumber() {

        if(symbolsFromNumber != null && symbolsFromNumber.length != 0) {

            int max = findMax(symbolsFromNumber);
            for(int i = 0; i < starSymbolCollection.length; i ++) {
                for (char c : symbolsFromNumber) {
                    if (c - 48 == max)
                        System.out.print(digitSymbolCollection[i][c - 48] + " ");
                    else if (c == 46)
                        System.out.print(starSymbolCollection[i][10] + " ");
                    else
                        System.out.print(starSymbolCollection[i][c - 48] + " ");
                }
                System.out.println();
            }
        }
        else
            System.out.println("Неверный формат числа");
    }
}
