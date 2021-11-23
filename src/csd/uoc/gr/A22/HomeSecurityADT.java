package csd.uoc.gr.A22;

import csd.uoc.gr.A21.SensorLine;

public abstract class HomeSecurityADT {
    String state;
    String pass;
    SensorLine[] SL1,SL2;
    HomeSecurityADT(SensorLine[] SL1,SensorLine[] SL2){
        this.pass="1111";
        this.SL1 = SL1;
        this.SL2 = SL2;
        this.state = "disarmed";
    }
    public abstract String SecurityState(SensorLine[] SL1,SensorLine[] SL2) throws Exception;
    public abstract void Arm(String state,SensorLine[] SL1,SensorLine[]SL2) throws Exception;
    public abstract void SetStay(String state,SensorLine[] SL1,SensorLine[] SL2);
    public abstract void Disarm(String pass,SensorLine[] SL1,SensorLine[] SL2) throws Exception;
    public abstract void SetNew() throws Exception;
    public abstract void setOpen(SensorLine[] SL1,SensorLine[] SL2) throws Exception;
}
