package com.mit_technologies.drillercaddie;

public class RPMKey extends Key {

    public RPMKey(){
        title = "RPM";
        periods = new int[]{20,30,60};
    }

    @Override
    public String getDescription() {
        return "RPM Key Description";
    }
}
