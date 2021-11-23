package csd.uoc.gr.A22;

import csd.uoc.gr.A21.Sensor;
import csd.uoc.gr.A21.SensorLine;
import java.util.Scanner;

public class HomeSecurity extends HomeSecurityADT{

    private boolean[] on1,on2;
    Scanner scanner = new Scanner(System.in);

    public HomeSecurity(SensorLine[] SL1, SensorLine[] SL2) {
        super(SL1, SL2);
    }

    public SensorLine[] getSL1(){return this.SL1;}
    public SensorLine[] getSL2(){return this.SL2;}
    public String getState(){return state;}
    public void setPass(String ps){this.pass = ps;}
    public void setState(String st){this.state =st;}
    public void setOpen(SensorLine[] SL1,SensorLine[] SL2) throws Exception{
        boolean[] SL1_on,SL2_on;
        for(int i=0;i<SL1.length;i++){
            SL1_on = SL1[i].GetOn();
            on1[i]=SL1_on[0];
            for(int j=0;j<SL1.length;j++){
                if(on1[i]!=SL1_on[j]){
                    throw new Exception("InternalSensorViolationError");
                }
            }
        }
        for(int i=0;i<SL2.length;i++){
            SL2_on = SL2[i].GetOn();
            on2[i] = SL2_on[0];
            for(int j=0;j<SL2.length;j++){
                if(on2[i]!=SL2_on[j]){
                    throw new Exception("ExternalSensorViolationError");
                }
            }
        }


    }
    public String SecurityState(SensorLine[] SL1, SensorLine[] SL2) throws Exception {
        String[] state1= new String[SL1.length];
        String[] state2 = new String[SL2.length];
        for(int i=0;i<SL1.length;i++){
            if(on1[i]&&(!SL1[i].isViolated())){
                state1[i]="armed";
            }else if(!on1[i]&&(!SL1[i].isViolated())){
                state1[i]="disarmed";
            }else{
                throw new Exception("InternalSensorViolationException");
            }
        }
        for(int i=0;i<SL2.length;i++){
            if(on2[i]&&!SL2[i].isViolated()){
                state2[i]="armed";
            }else if(!on2[i]&&!SL2[i].isViolated()){
                state2[i]="disarmed";
            }else{
                throw new Exception("ExternalSensorViolationError");
            }
        }
        String st1=state1[0],st2=state2[0];
        for(int i=0;i< state1.length;i++){
            if(!state1[i].equals(st1)){
                throw new Exception("InternalSensorViolationError");
            }
        }
        for(int i=0;i<state2.length;i++){
            if(!state2[i].equals(st2)){
                throw new Exception("ExternalSensorViolationError");
            }
        }
        if(state1[0]==state2[0]){
            return state1[0];
        }else{
            return "stay";
        }
    }
    public void Arm(String state, SensorLine[] SL1, SensorLine[] SL2)throws Exception{
        if (state.equals("unarmed")) {
            for(int i=0;i<SL1.length;i++){
                SL1[i].setOn(true);
            }
            for(int i=0;i<SL2.length;i++){
                SL2[i].setOn(true);
            }
        }else{
            String st1="unarmed",st2="unarmed";
            for(int i=0;i<SL1.length;i++){
                if(on1[i]){
                    st1="armed";
                }
            }
            for(int i=0;i<SL2.length;i++){
                if(on2[i]){
                    st2="armed";
                }
            }
            if(st1.equals("armed")){
                throw new Exception("InternalSensorViolationError");
            }
            if(st2.equals("armed")){
                throw new Exception("ExternalSensorViolationError");
            }
        }
    }
    public void SetStay(String state,SensorLine[] SL1,SensorLine[] SL2){
        if(state.equals("disarmed")){
            for(int i=0;i<SL2.length;i++){
                SL2[i].setOn(true);
                on2[i] = true;
            }
            setState("stay");
        }else{
            String st1="disarmed",st2="disarmed";
            for(int i=0;i<SL1.length;i++){
                if(SL1[i].isViolated()){
                    st1="armed";
                }
            }
            for(int i=0;i<SL2.length;i++){
                if(on2[i]){
                    st2="armed";
                    on2[i]=true;
                }
            }
        }
    }
    public void Disarm(String pass,SensorLine[] SL1,SensorLine[] SL2) throws Exception{
        String ps;
        System.out.println("Give the correct password:");
        ps = scanner.nextLine();
        if(ps.equals(pass)){
            for(int i=0;i<SL1.length;i++){
                if(on1[i]&&(!SL1[i].isViolated())) {
                    SL1[i].setOn(false);
                }else if(SL1[i].isViolated()){
                    throw new Exception("InternalSensorViolationError");
                }
            }
            for(int i=0;i<SL2.length;i++){
                if(on2[i]&&(!SL2[i].isViolated())){
                    SL2[i].setOn(false);
                }else{
                    throw new Exception("ExternalSensorViolationError");
                }
            }
        }else{
            throw new Exception("WrongPasswordException");
        }
    }
    public void SetNew() throws Exception{
        if(state.equals("disarmed")){
            String old_pass=scanner.nextLine();
            if(old_pass.equals(this.pass)){
                String new_pass = scanner.nextLine();
                setPass(new_pass);
            }else{
                throw new Exception("WrongPasswordException");
            }
        }else{
            throw new Exception("NotDisarmedException");
        }
    }
}
