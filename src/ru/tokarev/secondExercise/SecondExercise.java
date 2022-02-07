package ru.tokarev.secondExercise;

/** Пока divisor(делитель) в квадрате <= введенному числу(numb), делаем проверку:
 * 1) если число делится на делитель без остатка, значит это простой множитель, печатаем его,
 * делим наше число на делитель
 * 2) иначе есле не делится и делитель равен двум, повышаем значение делителя до 3
 * 3) иначе к делителю прибавляем 2
 **/

public class SecondExercise {

    /** To run app just use SecondExercise.solution() method **/
    public static void solution() {

        SimpleMultiplierSearchService service = new SimpleMultiplierSearchService();
        service.setNumber();
        service.getSimpleMultipliers();

    }
}
