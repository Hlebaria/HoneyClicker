package org.example.model;

public class BeeHive extends Item {

    public BeeHive(){
        super();
        description = "BEEHIVE\n\nAll bees in the beehive work together to make honey.\nA beehive makes 30 droplets of honey every hour.\nWorks during the day.";
        honeyPerTick = 30;
        timeInterval = 1000; //1 sec
        dayShift = true;
        nightShift = false;
        price = 200;
    }

}
