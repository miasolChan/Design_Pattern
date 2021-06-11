package strategy.behavior;

import strategy.interf.WeaponBehavior;

public class BowAndArrowBehavior implements WeaponBehavior {


    @Override
    public void useWeapon() {
        System.out.println("use the bow and arrow");
    }
}
