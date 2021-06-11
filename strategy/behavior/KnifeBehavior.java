package strategy.behavior;

import strategy.interf.WeaponBehavior;

public class KnifeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("use the knife");

    }
}
