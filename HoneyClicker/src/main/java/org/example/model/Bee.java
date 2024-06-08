package org.example.model;

public class Bee extends Item{

    public Bee(){
        super();
        description = "BEE\n\nAn honest worker that makes honey.\nA bee makes 1 droplet of honey each second.\nWorks during the day.";
        honeyPerTick = 1;
        timeInterval = 1000; //1 sec
        dayShift = true;
        nightShift = false;
        price = 30;
    }

}
