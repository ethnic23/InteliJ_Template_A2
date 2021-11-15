package csd.uoc.gr.A23;

public class HouseStark extends GreatHouse {
    private static HouseStark instance = null;

    private HouseStark(String name, String sigil, String words, String lord) {
        super(name, sigil, words, lord);
    }

    public static HouseStark getInstance() {
        if (instance == null) {
            instance = new HouseStark("Stark", "A grey direwolf on a white field", "Winter Is Coming", "Eddark Stark");
        }
        return instance;
    }
}
