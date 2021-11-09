package csd.uoc.gr.A21;

public class Sensor {
    private String id;
    private boolean violation;
    private boolean on;

    public void setid(String newid){id = newid;}
    public void seton(boolean newon){on = newon;}
    public void setviolation(boolean newviolation){violation = newviolation;}

    public String getId(){return id;}
    public boolean getViolation(){return violation;}
    public boolean getOn(){return on;}

    Sensor(String id,boolean violation,boolean on){
        setid(id);
        setviolation(violation);
        seton(on);
    }
    public  String toString(){
        return "Sensor with id=" + id + ", On state= " + on + ", Violation state = " + violation;
    }
}

class TemperatureSensor extends Sensor{

    TemperatureSensor(String id, boolean violation, boolean on) {
        super(id, violation, on);
    }
    @Override
    public String toString(){
        return "Sensor with id=" + getId() + ", On state= " + getOn() + ", Violation state = " + getViolation()+", (temp. sensor)";
    }
}

class LaserSensor extends Sensor{
    private float range;
    public void setRange(float newRange){range=newRange;}

    LaserSensor(String id, boolean violation, boolean on,float range) {
        super(id, violation, on);
        setRange(range);
    }
    @Override
    public String toString(){
        return "Sensor with id=" + getId() + ", On state= " + getOn() + ", Violation state = " + getViolation()+", range= "+range+", (laser sensor)";
    }
}
