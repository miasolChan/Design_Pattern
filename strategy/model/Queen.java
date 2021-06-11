package strategy.model;

public class Queen extends Character {

    public Queen() {
        display();
    }

    @Override
    public void fight() {
        useWeapon();
    }

    @Override
    public void display() {
        System.out.println("I'm a Queen!");
    }
}
