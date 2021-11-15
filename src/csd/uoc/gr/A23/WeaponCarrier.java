package csd.uoc.gr.A23;

public abstract class WeaponCarrier {
    Weapon weapon;

    public WeaponCarrier() {
        weapon = null;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    abstract void setWeapon(Weapon weapon);

    public boolean hasWeapon() {
        return weapon != null;
    }
}
