package com.example.rabbittank.banvexedien;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.robotium.solo.Solo;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class SingleTest {
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

    @Test
    public void BlackBoxGivenInvaildHourThenKhongHople() throws  Exception{
        solo.unlockScreen();
        solo.setTimePicker(0, 0, 0);
        solo.waitForText("Khong hop le", 1, 2000);
        assertTrue("Ket qua khong dung", solo.searchText("Khong hop le"));
    }

    @Test
    public void WhiteBoxGivenInvaildHourThenKhongHople() throws  Exception{
        solo.unlockScreen();
        solo.setTimePicker(0, 0, 0);
        solo.waitForText("Khong hop le", 1, 2000);
        assertTrue("Ket qua khong dung", solo.searchText("Khong hop le"));
    }
}
