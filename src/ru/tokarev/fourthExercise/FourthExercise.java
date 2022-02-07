package ru.tokarev.fourthExercise;

/**
 * Приложение состоит из класса PrintNumberService, в котором находится все необходимые поля и методы для
 * требуемого по условию вывода числа.
 * **/

public class FourthExercise {

    /** To run app just use FourthExercise.solution() method **/
    public static void solution() {
        String number = "876.65";

        PrintNumberService printNumberService = new PrintNumberService(number);
        printNumberService.printNumber();
    }

}
