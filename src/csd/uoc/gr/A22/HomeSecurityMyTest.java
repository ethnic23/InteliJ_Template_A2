package csd.uoc.gr.A22;

import csd.uoc.gr.A21.LaserSensor;
import csd.uoc.gr.A21.SensorLine;
import csd.uoc.gr.A21.TemperatureSensor;

import java.util.Scanner;

public class HomeSecurityMyTest {
    public static void main(String[] args) throws Exception {
        SensorLine[] SL1=new SensorLine[2];
        SensorLine[] SL2=new SensorLine[2];


        for(int i=0;i<100;i++){
            SL1[0].add(new LaserSensor("SID" + i));
            SL1[1].add(new LaserSensor("SID"+i));
            SL2[0].add(new TemperatureSensor("SID"+i));
            SL2[1].add(new LaserSensor("SID"+i));
        }
        HomeSecurity HS = new HomeSecurity(SL1,SL2);
        HS.setState(HS.SecurityState(SL1,SL2));
        HS.Arm(HS.getState(),SL1,SL2);
        HS.Disarm("1111",SL1,SL2);
        HS.SetNew();
        HS.SetStay(HS.getState(),SL1,SL2);
        Scanner scanner = new Scanner(System.in);
        String pass = scanner.nextLine();
        HS.Disarm(pass,SL1,SL2);
    }

}
