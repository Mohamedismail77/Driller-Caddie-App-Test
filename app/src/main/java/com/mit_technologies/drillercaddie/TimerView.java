package com.mit_technologies.drillercaddie;

public interface TimerView {

    void onTimerStart();
    void onTimerProgress(int progress);
    void onTimerFinish();
    void onTimerReset();

}
