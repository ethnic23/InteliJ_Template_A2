package csd.uoc.gr.A21;

public class LaserSensor extends Sensor {
    private float range;

    public void setRange(float newRange) {
        this.range = newRange;
    }
    public LaserSensor(String id){
        super(id,false,false);
        setRange(10f);
    }

    public LaserSensor(String id, boolean violation, boolean on, float range) {
        super(id, violation, on);
        setRange(range);
    }

    @Override
    public String toString() {
        return "Sensor with id=" + getId() + ", On state= " + getOn() + ", Violation state = " + getViolation() + ", range= " + range + ", (laser sensor)";
    }
}
