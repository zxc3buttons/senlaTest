package ru.tokarev.fifthExercise;

public class Safe {

        private final Item[] items;
        private final int price;

        public Safe(Item[] items, int price) {
            this.items = items;
            this.price = price;
        }

        public Item[] getItems() {
            return items;
        }

        public int getPrice() {
            return price;
        }

        public static Safe mergeTwoSafes(Item[] items1, Item[] items2, int price) {

            Item[] mergedItems = new Item[items1.length + items2.length];
            System.arraycopy(items1, 0, mergedItems, 0, items1.length);
            System.arraycopy(items2, 0, mergedItems, items1.length, items2.length);

            return new Safe(mergedItems, price);
        }

        public void getDescriptionForSafes() {
            if(items.length > 1) {
                for(Item item: items){
                    if(item != items[items.length - 1])
                        System.out.print(item.getName() + "-" + item.getPrice() + "+");
                    else
                        System.out.print(item.getName() + "-" + item.getPrice() + " ");
                }
            }
            else
                for(Item item: items)
                    System.out.print(item.getName() + "-" + item.getPrice() + " ");
        }
}
