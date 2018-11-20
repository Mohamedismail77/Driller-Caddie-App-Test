package com.mit_technologies.drillercaddie;

import android.os.CountDownTimer;

public class KeyPresenter {

    private Key[] mKeys;
    private KeyView mKeyView;
    private TimerView mTimerView;
    private CountDownTimer countDownTimer;

    public KeyPresenter(KeyView keyView, TimerView timerView) {

        //Create new Keys Array to used in Key DropDown list
        this.mKeys = new Key[]{new RPMKey(), new FlowOrPressureKey()};

        this.mTimerView = timerView;
        this.mKeyView = keyView;

    }

    /* getKeyTitles: Provide the DropDown list with string array of available tools  */
    public String[] getKeyTitles() {
        // create string array to hold Modes titles
        String[] mKeysTitles = new String[mKeys.length];

        // Iterate over Keys array
        for (int i = 0; i < mKeys.length; i++) {
            mKeysTitles[i] = mKeys[i].title;
        }

        return mKeysTitles;
    }

    /* setPeriodList: return selected key periods through keyView interface
       @params: keyIndex => Selected key Position from dropDown list
     */
    public void setPeriodList(int keyIndex) {

        // create string array to hold the periods of selected key
        String[] mKeyPeriods = new String[mKeys[keyIndex].periods.length];

        // Iterate over periods array
        for (int i = 0; i < mKeys[keyIndex].periods.length; i++) {
            mKeyPeriods[i] = String.valueOf(mKeys[keyIndex].periods[i]);
        }
        mKeyView.onKeyChanged(mKeyPeriods);

    }


    /* startTimer: Start countDown Timer and publish the progress timer view
       @params: keyIndex => Selected key Position from dropDown list
       @params: periodIndex => Selected Period Position from dropDown list
    */
    public void startTimer(int keyIndex, int periodIndex) {

        final int progressInterval = mKeys[keyIndex].periods[periodIndex] * 1000;
        //Show Progress and set its max value

        mTimerView.onTimerStart(progressInterval);

        // Initiate counterDown timer
        countDownTimer = new CountDownTimer(progressInterval, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                // publish progress through timerView interface
                mTimerView.onTimerProgress((int) (progressInterval - millisUntilFinished));
            }

            @Override
            public void onFinish() {

                //Reset TimerView and enable dropDown lists again
                mTimerView.onTimerReset();
            }
        }.start();

    }


    /* continueTimer: Start countDown Timer and publish the progress timer view
       @params: keyIndex => Selected key Position from dropDown list
       @params: periodIndex => Selected Period Position from dropDown list
       @params: progress => Current Progress of timer

    */
    public void continueTimer(int keyIndex, int periodIndex, final int progress) {

        final int progressInterval = mKeys[keyIndex].periods[periodIndex] * 1000;
        //Show Progress and set its max value

        mTimerView.onTimerStart(progressInterval);

        // Initiate counterDown timer
        countDownTimer = new CountDownTimer(progressInterval-progress, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                // publish progress through timerView interface
                mTimerView.onTimerProgress((int) (progressInterval - millisUntilFinished));
            }

            @Override
            public void onFinish() {

                //Reset TimerView and enable dropDown lists again
                mTimerView.onTimerReset();
            }
        }.start();

    }


    /* Stop or reset timer view in case of finish of counting or reset button pressed */
    public void stopTimer() {
        countDownTimer.cancel();
        mTimerView.onTimerReset();
    }


}
