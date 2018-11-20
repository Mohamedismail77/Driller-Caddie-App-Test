package com.mit_technologies.drillercaddie;

public class BypassMode extends Mode{

    public BypassMode(){
        title = "Bypass";
        icon = R.drawable.image2;
    }

    @Override
    public String getDescription() {
        return "Bypass Mode Description";
    }
}
