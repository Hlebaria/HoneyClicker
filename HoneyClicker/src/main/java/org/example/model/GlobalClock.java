package org.example.model;

public class GlobalClock {

    private static GlobalClock instance = new GlobalClock();
    private static int hours = 0;

    public static GlobalClock getInstance() {
        return instance;
    }

    public void addHour(){
        hours++;
        if(hours >= 24){
            hours = 0;
        }

        Game.advanceTime();

    }

    public static boolean daytime(){
        return hours > 6 & hours <= 18;
    }

    public int getHours(){
        return hours;
    }

}
