package csd.uoc.gr.A21;

public class Sensor {
    private String id;
    private boolean violation;
    private boolean on;

    public void setid(String newid){id = newid;}
    public void seton(boolean newon){on = newon;}
    public void setViolation(boolean newviolation){violation = newviolation;}

    public String getId(){return id;}
    public boolean getViolation(){return violation;}
    public boolean getOn(){return on;}

    public Sensor(String id, boolean violation, boolean on){
        setid(id);
        setViolation(violation);
        seton(on);
    }
    public  String toString(){
        return "Sensor with id=" + id + ", On state= " + on + ", Violation state = " + violation;
    }
}

