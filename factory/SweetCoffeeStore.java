package factory;

public class SweetCoffeeStore extends CoffeeStore {


    @Override
    protected Coffee createCoffee(String type) {
        Coffee coffee;
        switch (type){
            case "Latte":
                coffee = new SweetLatteCoffe();
                break;
            case "Espresso":
                coffee = new SweetEspressoCoffe();
                break;
            default:
                coffee = new NullCoffee();
                break;
        }
        return coffee;
    }
}
