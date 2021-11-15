package csd.uoc.gr.A23;

public abstract class Soldier extends WeaponCarrier implements Warrior {
    final String firstName;
    final String lastName;
    int health, power;

    public Soldier(String firstName, String lastName, int health, int power) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.health = health;
        this.power = power;
    }

    public int getHealthCondition() {
        return health;
    }

    public void setHealthCondition(int condition) {
        if (!(this.isDefeated())) {
            this.health = condition;
        }
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public String getCallSign() {
        return firstName + " " + lastName;
    }

    public int getPower() {
        return power;
    }

    public abstract String toString();
}
