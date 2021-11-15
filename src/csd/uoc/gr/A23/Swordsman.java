package csd.uoc.gr.A23;

public class Swordsman extends Soldier {
    public Swordsman(String firstName, String lastName) {
        super(firstName, lastName, (int) Math.floor(Math.random() * (10 - 5 + 1) + 5), 4);
    }

    public Swordsman(String firstName, String lastName, int health) {
        super(firstName, lastName, health, 4);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "The swordsman " + this.getCallSign() + " has power " + this.getPower() + " and health " + this.getHealthCondition() + ".";
    }

    @Override
    public void attack(Warrior adversary) {

    }
}
