package csd.uoc.gr.A22;

import csd.uoc.gr.A21.SensorLine;

class HomeSecurityADT {
    private String state;
    public void setState(String st){state =st;}

    HomeSecurityADT(SensorLine[] SL1,SensorLine[] SL2) throws Exception {
        SecurityState(SL1,SL2);
    }
    public void SecurityState(SensorLine[] SL1,SensorLine[] SL2) throws Exception {
        String[] state1= new String[SL1.length];
        String[] state2 = new String[SL2.length];
        for(int i=0;i<SL1.length;i++){
            if(SL1[i].isViolated()){
               state1[i]="armed";
            }else{
                state1[i]="disarmed";
            }
        }
        for(int i=0;i<SL2.length;i++){
            if(SL2[i].isViolated()){
                state2[i]="armed";
            }else{
                state2[i]="disarmed";
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
    }
    public void Arm(String state,SensorLine[] SL1,SensorLine[] SL2)throws Exception{
        if (state == "unarmed") {
            for(int i=0;i<SL1.length;i++){
                SL1[i].setOn(true);
            }
            for(int i=0;i<SL2.length;i++){
                SL2[i].setOn(true);
            }
        }else{
            String st1="unarmed",st2="unarmed";
            for(int i=0;i<SL1.length;i++){
                if(SL1[i].isViolated()){
                    st1="armed";
                }
            }
            for(int i=0;i<SL2.length;i++){
                if(SL2[i].isViolated()){
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
        if(state.equals("unarmed")){
            for(int i=0;i<SL2.length;i++){
                SL2[i].setOn(true);
            }
            setState("stay");
        }else{
            String st1="unarmed",st2="unarmed";
            for(int i=0;i<SL1.length;i++){
                if(SL1[i].isViolated()){
                    st1="armed";
                }
            }
            for(int i=0;i<SL2.length;i++){
                if(SL2[i].isViolated()){
                    st2="armed";
                }
            }
        }
    }
}
