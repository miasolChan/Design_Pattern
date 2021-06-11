package strategy.behavior;

import strategy.interf.WeaponBehavior;

public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("use the sword");
    }
}
