package strategy.model;

public class Knight extends Character {

    public Knight() {
        display();
    }

    @Override
    public void fight() {
        useWeapon();

    }
    @Override
    public void display(){
        System.out.println("I'm a Knight!");
    }
}
