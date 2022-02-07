package ru.tokarev.fifthExercise;

public class ResultTable {

    private final int amountOfItems;
    private final int weight;
    private final Item[] items;
    private final Safe[][] safesTable;

    public ResultTable(int amountOfItems, int weight, Item[] items) {
        this.amountOfItems = amountOfItems;
        this.weight = weight;
        this.items = items;
        safesTable = new Safe[this.amountOfItems + 1][this.weight + 1];
    }

    /** Алгоритм, создающий результирующую таблицу. Последний элемент таблицы - есть лучшая комбинация **/
    public void doResultTable() {

        for (int i = 0; i < amountOfItems + 1; i++) {
            for (int j = 0; j < weight + 1; j++) {
                if (i == 0 || j == 0) {
                    safesTable[i][j] = new Safe(new Item[]{}, 0);
                }
                else if (i == 1) {
                    safesTable[1][j] = items[0].getWeight() <= j ?
                            new Safe(new Item[]{items[0]}, items[0].getPrice())
                            : new Safe(new Item[]{}, 0);
                }
                else {
                    if (items[i - 1].getWeight() > j)
                        safesTable[i][j] = safesTable[i - 1][j];
                    else {
                        int newPrice = items[i - 1].getPrice() +
                                safesTable[i - 1][j - items[i - 1].getWeight()].getPrice();
                        if (safesTable[i - 1][j].getPrice() > newPrice)
                            safesTable[i][j] = safesTable[i - 1][j];
                        else {
                            safesTable[i][j] = Safe.mergeTwoSafes(new Item[]{items[i - 1]},
                                    safesTable[i - 1][j - items[i - 1].getWeight()].getItems(), newPrice);
                        }
                    }
                }
            }
        }
    }

    public void printResultTable() {
        System.out.println("Варианты наборов:");
        for (int i = 0; i < amountOfItems + 1; i++) {
            for (int j = 0; j < weight + 1; j++) {
                safesTable[i][j].getDescriptionForSafes();
            }
            System.out.println();
        }
    }

    public void printMaxSafeKit() {
        System.out.println("\nНабор с максимальной ценностью:");
        safesTable[amountOfItems][weight].getDescriptionForSafes();
    }

    public Safe getMaxSafeKit() {
        return safesTable[amountOfItems][weight];
    }
}
