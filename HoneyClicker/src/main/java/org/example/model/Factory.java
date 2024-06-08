package org.example.model;

public class Factory extends Item{

    public Factory(){
        super();
        description = "HONEY FACTORY\n\nIndustrial grade facility for making honey.\nA factory makes 500 droplets of honey each second.\nWorks during the day.";
        honeyPerTick = 500;
        timeInterval = 1000; //1 sec
        dayShift = true;
        nightShift = false;
        price = 10000;
    }
}
