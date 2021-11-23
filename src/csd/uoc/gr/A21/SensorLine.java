package csd.uoc.gr.A21;

public class SensorLine {
    private final String id = "Anonymous sensorLine ";
    private int activeCapacity = 0;
    int num_violated = 0;
    public SensorLine(){}
    public SensorLine(int loc,int M){
        if(loc == 1){
            for(int i=0;i<M;i++){
                add(new LaserSensor("SID"+i));
            }
        }else{
            for(int i=0;i<M;i++){
                if(i%2==0){
                    add(new LaserSensor("SID"+i));
                }else{
                    add(new TemperatureSensor("SID"+i));
                }
            }
        }
    }
    String[] violated_id = new String[1000];
    public String getId(){return this.id;}

    public void setActiveCapacity(int cap) {activeCapacity = cap;}

    private final Sensor[] sensors = new Sensor[1000];

    public void add(Sensor s) {

        if (activeCapacity < 1000) {
            sensors[activeCapacity] = s;
            setActiveCapacity(activeCapacity + 1);
        }

    }
    private boolean[] on = new boolean[activeCapacity];

    public boolean[] GetOn(){
        SetOn();
        return on;
    }
    public void setOn(boolean on) {
        for (int i = 0; i <= activeCapacity; i++) sensors[i].seton(on);
    }

    public boolean isViolated() {
        boolean violated = false;
        for (int i = 0; i < activeCapacity; i++) {
            if (sensors[i].getViolation()) {
                violated = true;
                violated_id[num_violated] = sensors[i].getId();
                num_violated++;
            }
        }
        return violated;
    }

    public String violatedSens() {
        String s = "";
        boolean b = (num_violated == 0);
        if (b) {
            return s + " ";
        } else {
            for (int i = 0; i < num_violated; i++) {
                s = s + violated_id[i] + " ";
            }
        }
        return s;
    }

    public Sensor[] getSensors() {
        Sensor[] ActiveSensors = new Sensor[activeCapacity];
        for (int i = 0; i < activeCapacity; i++) {
            ActiveSensors[i] = sensors[i];
        }
        return ActiveSensors;
    }
    public void SetOn(){
        Sensor[] AS;
        AS = getSensors();
        for(int i=0;i<AS.length;i++){
            on[i]= AS[i].getOn();
        }
    }
    @Override
    public String toString() {
        return "SensorLine " + id + "\nNumber of Sensors =" + (activeCapacity) + "\nviolated =" + isViolated() + "\n# of violated sensors=" + num_violated + "\nIds Violated: " + violatedSens();
    }
}
