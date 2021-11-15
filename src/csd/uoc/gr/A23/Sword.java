package csd.uoc.gr.A23;

public class Sword extends Weapon {
    public Sword() {
        super((int) Math.floor(Math.random() * (4 - 3 + 1) + 3));
    }

    public Sword(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "The Sword has power " + this.getPower() + " and is owned by " + this.getHolder() + ".";
    }
}
