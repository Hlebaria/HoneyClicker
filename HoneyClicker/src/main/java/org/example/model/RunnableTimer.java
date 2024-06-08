package org.example.model;

public class Worker implements Runnable {

    private final float honeyPerTick;
    private final long timeInterval;
    private final boolean dayShift;
    private final boolean nightShift;

    public Worker(float honeyPerTick, long timeInterval, boolean dayShift, boolean nightShift){
        this.honeyPerTick = honeyPerTick;
        this.timeInterval = timeInterval;
        this.dayShift = dayShift;
        this.nightShift = nightShift;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(timeInterval);
                if((GlobalClock.daytime() && dayShift) || (!GlobalClock.daytime() && nightShift)){
                    generateHoney();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateHoney(){
        Game.increaseHoney(honeyPerTick);
    }
}
