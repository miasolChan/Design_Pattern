package factory;

public class BlackCoffeeStore extends CoffeeStore{

    @Override
    protected Coffee createCoffee(String type) {
        Coffee coffee;
        switch (type){
            case "Latte":
                coffee = new BlackLatteCoffe();
                break;
            case "Espressp":
                coffee = new BlackEspressoCoffe();
                break;
            default:
                coffee = new NullCoffee();
                break;
        }
        return coffee;
    }
}
