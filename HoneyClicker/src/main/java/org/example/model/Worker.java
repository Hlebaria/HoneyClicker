package org.example.model;

import java.time.Duration;

public class Worker implements Runnable {

    private float honeyPerTick;
    private float timeInterval;
    private boolean dayShift;
    private boolean nightShift;


    public Worker(float honeyPerTick, float timeInterval, boolean dayShift, boolean nightShift){
        //initiate
    }

    @Override
    public void run() {
        //thread behaiviour
    }
}
