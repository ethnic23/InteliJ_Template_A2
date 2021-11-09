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
class SensorLine {
    private String id= "Anonymous sensorLine ";
    private int activeCapacity = 0;
    int num_violated = 0;
    String[] violated_id= new String[num_violated];

    public void setActiveCapacity(int cap){activeCapacity = cap;}
    private Sensor[] sensors = new Sensor[1000];
    public void add(Sensor s){

        if(activeCapacity<1000){
            sensors[activeCapacity]=s;
        }
        setActiveCapacity(activeCapacity+1);
    }
    public void setOn(boolean on){
        for(int i=0;i<activeCapacity+1;i++) sensors[i].seton(on);
    }
    public boolean isViolated(){
        boolean violated=false;
        for(int i=0;i<activeCapacity+1;i++){
            if(sensors[i].getViolation()){
                violated = true;
                num_violated++;
                violated_id[num_violated]= sensors[i].getId();
            }
        }
        return violated;
    }
    public String violatedSens(){
        String s= "";
        boolean b =(num_violated == 0);
        if(b){
            return s+" ";
        }else{
            for (int i = 0; i < num_violated + 1; i++) {
                s=s+violated_id[i]+" ";
            }
        }
        return s;
    }
    public Sensor[] getSensors(){
        Sensor[] ActiveSensors = new Sensor[activeCapacity];
        for(int i=0;i<activeCapacity+1;i++){
            ActiveSensors[i]=sensors[i];
        }
        return ActiveSensors;
    }
    @Override
    public String toString(){
        return "SensorLine "+id +"\nNumber of Sensors ="+(activeCapacity+1)+"\nviolated ="+isViolated()+"\n# of violated sensors="+num_violated+"\nIds Violated: "+violatedSens();
    }
}
class SensorClient{
    public static void main(String[] args){
        System.out.println(new Sensor("S01",false,false));
        System.out.println(new TemperatureSensor("S02",false,false));
        System.out.println(new LaserSensor("S03",false,false,4F));
    }
}
