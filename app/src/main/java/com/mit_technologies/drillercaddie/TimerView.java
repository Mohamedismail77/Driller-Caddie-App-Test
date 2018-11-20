package com.mit_technologies.drillercaddie;

public interface TimerView {

    void onTimerStart(int interval);
    void onTimerProgress(int progress);
    void onTimerReset();

}
