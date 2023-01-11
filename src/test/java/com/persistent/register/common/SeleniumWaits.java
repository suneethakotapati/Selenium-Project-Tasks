package com.persistent.register.common;

import java.time.Duration;

public class SeleniumWaits {
    public static void timeout() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * This method will used to hard wait in the seconds time
     *
     * @param timeInSeconds - pass value of second(s) for wait
     */
    public static void timeout(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
