package factory;

/**
 * Created by xiehao on 4/12/16.
 */
public abstract class CoffeeStore {

    protected abstract Coffee createCoffee(String type);

    public Coffee orderCoffee(String type) {
        Coffee coffee = createCoffee(type);
        coffee.prepare();
        coffee.brew();
        coffee.pour();
        coffee.addSugar();
        return coffee;
    }
}
