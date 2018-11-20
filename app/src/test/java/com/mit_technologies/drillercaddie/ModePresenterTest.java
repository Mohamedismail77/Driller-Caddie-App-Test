package com.mit_technologies.drillercaddie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ModePresenterTest implements ModeView {

    private int mIndex;
    private String mExpectedResult;
    private ModePresenter mModePresenter = new ModePresenter(this);


    /* Testing Parameters */
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "Home"},
                {1, "Bypass"},
                {2, "Dual Flow"},
                {3, "Isolation"}
        });
    }


    /* Constructor */
    public ModePresenterTest(int mIndex, String mExpectedResult, int mExpectedIconResource) {
        this.mIndex = mIndex;
        this.mExpectedResult = mExpectedResult;
    }


    @Test
    public void getModeTitlesTest(){
        assertEquals(mExpectedResult,mModePresenter.getModeTitles()[mIndex]);
    }

    @Override
    public void onModeChanged(int modeIconResource) {

    }
}
