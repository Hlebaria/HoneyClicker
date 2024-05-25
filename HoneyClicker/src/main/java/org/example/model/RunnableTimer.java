package org.example.model;

public class RunnableTimer implements Runnable{

    GlobalClock clock;

    public RunnableTimer(GlobalClock clock){
        this.clock = clock;
    }

    @Override
    public void run() {

    }

}
