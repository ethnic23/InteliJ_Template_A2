package csd.uoc.gr.A21;

class SensorTESTER {
    public static void main(String[] args) {
        int i = 0;
        SensorLine SL = new SensorLine();
        System.out.println(new Sensor("S01", false, false));
        System.out.println(new TemperatureSensor("S02", false, false));
        System.out.println(new LaserSensor("S03", false, false, 4F));
        while (i < 100) {
            SL.add(new Sensor("SID" + i, true, false));
            SL.add(new TemperatureSensor("SID" + (i + 1), false, false));
            SL.add(new LaserSensor("SID" + (i + 2), false, false, 4F));
            SL.add(new Sensor("SID" + (i + 3), false, false));
            i += 4;
        }
        System.out.println(SL);
    }

}
