package org.example;

import org.example.model.Game;
import org.example.model.GlobalClock;
import org.example.model.RunnableTimer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Game game = Game.getInstance();

        GlobalClock clock = GlobalClock.getInstance();
        Thread runnableTimer = new Thread(new RunnableTimer(clock));
        runnableTimer.start();

    }
}
