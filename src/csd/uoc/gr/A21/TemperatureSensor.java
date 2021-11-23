package csd.uoc.gr.A21;

public class TemperatureSensor extends Sensor {

    public TemperatureSensor(String id){
        super(id,false,false);
    }
    public TemperatureSensor(String id, boolean violation, boolean on) {
        super(id, violation, on);
    }

    @Override
    public String toString() {
        return "Sensor with id=" + getId() + ", On state= " + getOn() + ", Violation state = " + getViolation() + ", (temp. sensor)";
    }
}
