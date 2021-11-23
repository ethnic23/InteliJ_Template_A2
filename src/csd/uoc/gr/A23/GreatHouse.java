package csd.uoc.gr.A23;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class GreatHouse {
    final String name, sigil, words, lord;
    final ArrayList<Soldier> army = new ArrayList<Soldier>();
    boolean empty =true;
    public GreatHouse(String name, String sigil, String words, String lord) {
        this.name = name;
        this.sigil = sigil;
        this.words = words;
        this.lord = lord;
    }

    public void addSoldier(Soldier soldier) {
        army.add(soldier);
        empty = false;
    }

    public Soldier getSoldier() {
        int randomElementIndex = ThreadLocalRandom.current().nextInt(army.size()) % army.size();
        while(army.get(randomElementIndex).isDefeated()){
            randomElementIndex = ThreadLocalRandom.current().nextInt(army.size())%army.size();
        }
        return army.get(randomElementIndex);
    }

    public boolean isDefeated() throws Exception {
        if(army.size()!=0){
            for (int i = 0; i < army.size(); i++) {
              if (!(army.get(i).isDefeated())) {
                    return false;
              }
            }
            return true;
        }else{
            throw new Exception("EmptyArmyExceptionError");
        }

    }

    public String toString() {
        return "The GreatHouse of " + this.name + "s has lord " + this.lord + ". The sigil is a '" + this.sigil + "' and their words are '" + this.words + "'.";
    }
}
