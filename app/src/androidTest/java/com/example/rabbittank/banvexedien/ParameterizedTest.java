package com.example.rabbittank.banvexedien;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private Solo solo;

    @Before
    //setUp() is run before a test cases are started.
    public void setUp(){
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), activityTestRule.getActivity());
    }

    @After
    //tearDown() is run after a tests are completed.
    public void tearDown(){
        solo.finishOpenedActivities();
    }

    @Parameters(name = "{index}:({0}h{1}p)={2}")
    public  static  Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, "Khong hop le"},
                {2, 0, "Khong hop le"},
                {3, 59, "Khong hop le"},
                {4, 0, "Ve thuong"},
                {6, 0, "Ve thuong"},
                {9, 29, "Ve thuong"},
                {9, 30, "Ve tiet kiem"},
                {12, 0, "Ve tiet kiem"},
                {16, 0, "Ve tiet kiem"},
                {16, 1, "Ve thuong"},
                {19, 30, "Ve thuong"},
                {19, 31, "Ve tiet kiem"},
                {21, 0, "Ve tiet kiem"},
                {22, 59, "Ve tiet kiem"},
                {23, 0, "Khong hop le"},
                {23, 30, "Khong hop le"},
        });
    }

    private int hourOfDay, minutes;
    private String expected;

    public ParameterizedTest(int hourOfDay, int minutes, String expected) {
        this.hourOfDay = hourOfDay;
        this.minutes = minutes;
        this.expected = expected;
    }

    @Test
    public void BlackBoxGivenHourMinuteThenResult() throws  Exception{
        solo.unlockScreen();
        solo.setTimePicker(0, hourOfDay, minutes);//=====
        solo.waitForText(expected, 1, 2000);
        assertTrue("Ket qua khong dung", solo.searchText(expected));//======
    }

    @Test
    public void WhiteBoxGivenHourMinuteThenResult() throws  Exception{
        solo.unlockScreen();
        solo.setTimePicker(activityTestRule.getActivity().getDpPicker(), hourOfDay, minutes);//=====
        solo.waitForText(expected, 1, 2000);
        assertEquals("Ket qua khong dung", expected, activityTestRule.getActivity().getTvResult().getText());//======
    }
}
