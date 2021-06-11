package strategy.model;

public class Troll extends Character {

    public Troll() {
        display();
    }

    @Override
    public void fight() {
        useWeapon();
    }

    @Override
    public void display() {
        System.out.println("I'm a Troll!");
    }
}
