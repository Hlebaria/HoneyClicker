package org.example.model;

public class GlobalClock {

    private static GlobalClock instance = new GlobalClock();
    private int hours = 0;

    public static GlobalClock getInstance() {
        return instance;
    }

    public void addHour(){
        hours++;
        if(hours >= 24){
            hours = 0;
        }
    }

    public int getHours(){
        return hours;
    }

    // Стартира часовника
    public void startClock(){
        new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(1000); // Спи за 1 секунда
                    addHour(); // Добавя 1 час
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
