package com.mit_technologies.drillercaddie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KeyPresenterTest implements KeyView, TimerView {


    private int mIndex;
    private String mExpectedResult;
    private KeyPresenter mKeyPresenter = new KeyPresenter(this,this);


    /* Testing Parameters */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "RPM"},
                {1, "Flow or Pressure"}
        });
    }


    /* Constructor */
    public KeyPresenterTest(int mIndex, String mExpectedResult) {
        this.mIndex = mIndex;
        this.mExpectedResult = mExpectedResult;
    }


    @Test
    public void getModeTitlesTest(){
        assertEquals(mExpectedResult,mKeyPresenter.getKeyTitles()[mIndex]);
    }


    @Override
    public void onKeyChanged(String[] keyPeriods) {

    }

    @Override
    public void onTimerStart(int interval) {

    }

    @Override
    public void onTimerProgress(int progress) {

    }

    @Override
    public void onTimerReset() {

    }
}
