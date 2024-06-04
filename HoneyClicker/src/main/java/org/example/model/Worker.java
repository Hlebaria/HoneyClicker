package org.example.model;

public class Worker implements Runnable {

    private float honeyPerTick;
    private long timeInterval;
    private boolean dayShift;
    private boolean nightShift;
    private GlobalClock clock;

    public Worker(float honeyPerTick, long timeInterval, boolean dayShift, boolean nightShift){
        this.honeyPerTick = honeyPerTick;
        this.timeInterval = timeInterval;
        this.dayShift = dayShift;
        this.nightShift = nightShift;
        this.clock = GlobalClock.getInstance();
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(timeInterval);
                int currentHour = clock.getHours();
                if((currentHour >= 6 && currentHour < 18 && dayShift) || (currentHour >= 18 || currentHour < 6 && nightShift)){
                    generateHoney();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateHoney(){
        // Add code here to generate honey
        System.out.println("Generated " + honeyPerTick + " units of honey");
    }
}
