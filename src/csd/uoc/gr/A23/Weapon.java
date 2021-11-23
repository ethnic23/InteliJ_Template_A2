package csd.uoc.gr.A23;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Weapon {
    private final int power;
    WeaponCarrier holder;

    Weapon(int power) {
        this.power = power;
    }

    public int getPower(){
        return power;
    }
    public void setHolder(WeaponCarrier holder){
        this.holder = holder;
    }

    public WeaponCarrier getHolder(){
        return holder;
    }
    public abstract String toString();
}

