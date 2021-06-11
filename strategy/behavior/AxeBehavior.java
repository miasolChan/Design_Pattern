package strategy.behavior;

import strategy.interf.WeaponBehavior;

public class AxeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("use the axe");
    }
}
