package ru.tokarev.secondExercise;

import java.util.Scanner;

public class SimpleMultiplierSearchService {
    private int number;
    private int divider;

    public SimpleMultiplierSearchService() {
        this.divider = 2;
    }

    public void setNumber() {
        Scanner scanner = new Scanner(System.in);

        if(scanner.hasNextInt())
            this.number = scanner.nextInt();
        else
            System.out.println("Введено не корректное значение");
    }

    public void getSimpleMultipliers() {

        while (divider * divider <= number) {

            if (number % divider == 0) {

                System.out.print(divider);
                number = number / divider;
                System.out.print("*");
            }
            else if (divider == 2) divider = 3;
            else divider = divider + 2;
        }
        System.out.print(number);
    }

}
