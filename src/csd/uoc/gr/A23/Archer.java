package csd.uoc.gr.A23;

public class Archer extends Soldier {
    public Archer(String firstName, String lastName) {
        super(firstName, lastName, (int) Math.floor(Math.random() * (5 - 1 + 1) + 1), 2);
    }

    public Archer(String firstName, String lastName, int health) {
        super(firstName, lastName, health, 2);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "The archer " + this.getCallSign() + " has power " + this.getPower() + " and health " + this.getHealthCondition() + ".";
    }

    @Override
    public void attack(Warrior adversary) {
        int enemyHealth = adversary.getHealthCondition();
        adversary.setHealthCondition(enemyHealth - power);
    }
}
