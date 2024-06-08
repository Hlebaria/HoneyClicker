package org.example.model;

public class Bank extends Item{

    public Bank(){
        super();
        description = "HONEY BANK\n\nUses the global economy to generate honey interest and gain honey.\nA bank makes 10,000 droplets of honey every hour.\nWorks day and night.";
        honeyPerTick = 10000;
        timeInterval = 1000; //1 sec
        dayShift = true;
        nightShift = false;
        price = 100000;
    }

}
