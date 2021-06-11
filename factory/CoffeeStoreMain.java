package factory;

public class CoffeeStoreMain {

    public static void main(String[] args) {
        CoffeeStore sweetStore= new SweetCoffeeStore();
        CoffeeStore blackStore= new BlackCoffeeStore();
        Coffee coffee= null;
        coffee = sweetStore.orderCoffee("Espresso");
        System.out.println("Iordered a cup of " + coffee.getName() + " coffee");
        System.out.println(coffee);
        System.out.println();
        coffee = sweetStore.orderCoffee("Latte");
        System.out.println("Uordered a cup of " + coffee.getName() + " coffee");
        System.out.println(coffee);
        System.out.println();
        coffee = blackStore.orderCoffee("Espresso");
        System.out.println("Iordered a cup of " + coffee.getName() + " coffee");
        System.out.println(coffee);
        System.out.println();
        coffee = blackStore.orderCoffee("Latte");
        System.out.println("Uordered a cup of " + coffee.getName() + " coffee");
        System.out.println(coffee);
        System.out.println();
    }

}
