package org.ooad_dws4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TimerModeTest {


    @Test
    void makeTimeForm(int i, int i1, int i2) {
        TimerMode timerMode = new TimerMode(true);
        System.out.println(timerMode.makeTimeForm(2,15,52));

    }

    @Test
    void makeView() {
        TimerMode timerMode = new TimerMode(true);
        timerMode.makeView().doMessageAction();
    }

    @Test
    void changeField() {

        TimerMode timerMode= new TimerMode(true);
        timerMode.modeModify(5);
        Message returnMessage = timerMode.modeModify(2);
        HashMap<String, String> arg = new HashMap<String, String>();
        arg.put("blink","4");

        assertEquals(returnMessage.getArg(),arg);

    }

    @Test
    void startTimer() {

        TimerMode timerMode= new TimerMode(true);

         Message returnMessage =timerMode.modeModify(3);
        HashMap<String, String> arg = new HashMap<String, String>();
        arg.put("0", "ringing");
        arg.put("1", "600000");
        arg.put("2", "351");

        assertEquals(arg,returnMessage.getArg());
    }

    @Test
    void pauseTimer() {

        TimerMode timerMode= new TimerMode(true);

        timerMode.modeModify(3);
        Message returnMessage =timerMode.modeModify(3);
        HashMap<String, String> arg = new HashMap<String, String>();
        arg.put("0", "off");
        arg.put("2", "351");

        assertEquals(arg,returnMessage.getArg());
    }

}