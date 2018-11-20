package com.mit_technologies.drillercaddie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class ToolPresenterTest {

    private int mIndex;
    private String mExpectedResult;
    private ToolPresenter mToolPresenter = new ToolPresenter();


    /* Testing Parameters */
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, "1"},
                {1, "2"},
                {2,"3"}
                });
    }

    /* Constructor */
    public ToolPresenterTest(int mIndex, String mExpectedResult) {
        this.mIndex = mIndex;
        this.mExpectedResult = mExpectedResult;
    }

    @Test
    public void getToolsNumbersTest(){
        assertEquals(mExpectedResult,mToolPresenter.getToolsNumbers()[mIndex]);
    }



}
