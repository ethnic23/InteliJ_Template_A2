package csd.uoc.gr.A23;

public class Arc extends Weapon {
    public Arc() {
        super((int) Math.floor(Math.random() * (2 - 1 + 1) + 1));
    }

    public Arc(int power) {
        super(power);
    }

    @Override
    public String toString() {
        return "The arc has power " + this.getPower() + " and is owned by " + this.getHolder() + ".";
    }
}
