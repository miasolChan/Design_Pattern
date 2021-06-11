package strategy.model;


public class King extends Character {

    public King() {
        display();
    }

    @Override
    public void fight() {
        useWeapon();
    }

    @Override
    public void display(){
        System.out.println("I'm a King!");
    }


}
