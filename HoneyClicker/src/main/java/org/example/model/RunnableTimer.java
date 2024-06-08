package org.example.model;

public class RunnableTimer implements Runnable{

    GlobalClock clock;

    public RunnableTimer(GlobalClock clock){
        this.clock = clock;
    }

    @Override
    public void run() {
        while(true) {

            try {
                Thread.sleep(1000); // Спи за 1 секунда
                synchronized (clock) {
                    clock.addHour();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
