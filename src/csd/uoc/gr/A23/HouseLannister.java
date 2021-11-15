package csd.uoc.gr.A23;

public class HouseLannister extends GreatHouse {
    private static HouseLannister instance = null;

    private HouseLannister(String name, String sigil, String words, String lord) {
        super(name, sigil, words, lord);
    }

    public static HouseLannister getInstance() {
        if (instance == null) {
            instance = new HouseLannister("Lannister", "A Golden lion rampant on a crimson field", "A Lannister Always Pays His Debts", "Tywin Lannister");
        }
        return instance;
    }
}
