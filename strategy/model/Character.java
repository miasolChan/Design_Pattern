package strategy.model;

import strategy.behavior.SwordBehavior;
import strategy.interf.WeaponBehavior;

public abstract class Character {

    private WeaponBehavior weaponBehavior;

    public Character() {
        setWeapon(new SwordBehavior());
    }

    public abstract void display();
    public abstract void fight();

    public void useWeapon(){
        weaponBehavior.useWeapon();
    }
    public void setWeapon(WeaponBehavior weaponBehavior){
        this.weaponBehavior = weaponBehavior;
    }

    public WeaponBehavior getWeapon() {
        return weaponBehavior;
    }
}
