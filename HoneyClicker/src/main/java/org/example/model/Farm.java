package org.example.model;

public class Farm extends Item{

    public Farm(){
        super();
        description = "HONEY FARM\n\nA special farm full of beehives that generate honey.\nA farm makes 100 droplets of honey every two hours.\nWorks day and night.";
        honeyPerTick = 100;
        timeInterval = 2000; //2 sec
        dayShift = true;
        nightShift = true;
        price = 1000;
    }

}
