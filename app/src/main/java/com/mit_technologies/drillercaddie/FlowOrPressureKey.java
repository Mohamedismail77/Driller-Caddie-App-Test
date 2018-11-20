package com.mit_technologies.drillercaddie;

public class FlowOrPressureKey extends Key {

    public FlowOrPressureKey(){
        title = "Flow or Pressure";
        periods = new int[]{60,90,120};
    }

    @Override
    public String getDescription() {
        return "Flow or Pressure Key Description";
    }
}
