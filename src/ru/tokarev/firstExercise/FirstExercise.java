package ru.tokarev.firstExercise;

/**
 * В классе NUmberSumService представлена реализация следующего алгоритма:
 *
 * введенную строку представляем в виде массива символов, далее проверяем каждый символ на
 * принадлежность множеству цифр в соответствии значениям из таблицы ASCII.
 * Если условие выполняется, прибавляем к сумме значение символа - 48, что будет соответствовать числу от 0 до 9
 *
 */

public class FirstExercise {

    /** To run app just use FirstExercise.solution() method **/
    public static void solution() {

        String numberString = "";
        NumberSumService service = new NumberSumService(numberString);

        int sum = service.getSum();
        System.out.println(sum);

    }
}
