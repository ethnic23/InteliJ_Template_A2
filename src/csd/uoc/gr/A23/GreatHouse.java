package csd.uoc.gr.A23;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GreatHouse {
    final String name, sigil, words, lord;
    List<Soldier> army;

    public GreatHouse(String name, String sigil, String words, String lord) {
        this.name = name;
        this.sigil = sigil;
        this.words = words;
        this.lord = lord;
    }

    public void addSoldier(Soldier soldier) {
        army.add(soldier);
    }

    public Soldier getSoldier() {
        int randomElementIndex = ThreadLocalRandom.current().nextInt(army.size()) % army.size();
        return army.get(randomElementIndex);
    }

    public boolean isDefeated() {
        for (int i = 0; i < army.size(); i++) {
            if (!(army.get(i).isDefeated())) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "The GreatHouse of " + this.name + "s has lord " + this.lord + ". The sigil is a '" + this.sigil + "' and their words are '" + this.words + "'.";
    }
}
