package ru.tokarev.fifthExercise;

/**
 * Задача решается методом динамического программирования - наиболее быстрым в сравнении с методом перебора
 *
 * Приложение состоит из класса Item, описывающим предмет и его свойства, Safe - описывающим свойства сейфа и
 * необходимые методы для работы с ним, ResultTable - класс результирующей таблицы - в нём находится сам алгоритм
 * и метод для вывода максимальной по стоимости комбинации**/

public class FifthExercise {

    /** To run app just use SecondExercise.solution() method **/
    public static void solution() {

        int weight = 4;

        Item[] items = {new Item("ноутбук", 3, 2000),
                new Item("сервер", 4, 3000),
                new Item("смартфон", 1, 1500)};

        // инициализация результуриющей таблицы параметрами сейфа и списка предметов
        ResultTable resultTable = new ResultTable(items.length, weight, items);
        // работа алгоритма
        resultTable.doResultTable();

        // получение сейфа с максимальной стоимостью набора
        Safe maxSafeKit = resultTable.getMaxSafeKit();
        maxSafeKit.getDescriptionForSafes();

    }
}




