package org.example.model;

public abstract class Item {

    protected int count;
    protected int capacity;
    protected float price;
    protected String description;

    protected float honeyPerTick;
    protected float timeInterval;
    protected boolean dayShift;
    protected boolean nightShift;

    public Item(){
        this.count = 0;
        this.capacity = 10;
    }

    public void buyItem(float accumulatedHoney){

        if(accumulatedHoney < price || count == capacity){
            return;
        }

        count++;
        Game.increaseHoney(-price);
        price = price + price/5;

        //round the price
        price = price - (price % 1);

        createWorker();

    }

    protected void createWorker(){
        new Thread(new Worker(honeyPerTick, (long) timeInterval, dayShift, nightShift)).start();
    }

    public java.lang.String getDescription() {
        return "Price: " + String.format("%.0f", price) + "\n" + description;
    }

    public int getCount(){
        return count;
    }

    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

}
