package com.mit_technologies.drillercaddie;


import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.ParameterizedRobolectricTestRunner;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(ParameterizedRobolectricTestRunner.class)
public class ModeViewTest {

    private int mIndex;
    private int mIconResource;
    private int mExpectedIconResource;
    private String mExpectedResult;

    private MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
    private ModePresenter mModePresenter = new ModePresenter(mainActivity);

    /* Testing Parameters */
    @ParameterizedRobolectricTestRunner.Parameters(name= "mode:{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "Home"},
                {1, "Bypass"},
                {2, "Dual Flow"},
                {3, "Isolation"}
        });
    }


    /* Constructor */
    public ModeViewTest(int mIndex, String mExpectedResult) {
        this.mIndex = mIndex;
        this.mExpectedResult = mExpectedResult;
    }

    @Test
    public void ModeSpinnerTest(){
        assertEquals(mExpectedResult,mainActivity.mode.getItemAtPosition(mIndex));


    }

}
