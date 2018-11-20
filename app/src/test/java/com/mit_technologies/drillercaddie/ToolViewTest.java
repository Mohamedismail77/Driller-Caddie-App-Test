package com.mit_technologies.drillercaddie;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class ToolViewTest {

    @Test
    public void ToolSpinnerTest(){
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        assertEquals(0,mainActivity.toolNum.getSelectedItemPosition());
        assertEquals("1",mainActivity.toolNum.getSelectedItem());
        assertEquals("1",mainActivity.toolNum.getItemAtPosition(0));
        assertEquals("2",mainActivity.toolNum.getItemAtPosition(1));
        assertEquals("3",mainActivity.toolNum.getItemAtPosition(2));

    }






}
