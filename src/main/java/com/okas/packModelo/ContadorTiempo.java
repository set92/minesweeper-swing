package com.okas.packModelo;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class ContadorTiempo extends Observable{
    private boolean running;
    private int timeSeconds, timeMinutes;
    private static ContadorTiempo mContadorTiempo;

    private ContadorTiempo(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                updateSeconds();
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 1000);
    }

    public static ContadorTiempo getGestor(){
        if(mContadorTiempo == null) mContadorTiempo = new ContadorTiempo();
        return mContadorTiempo;
    }
    
    public String getTiempo(){
        return timeMinutes+":"+timeSeconds;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    private void updateSeconds(){
        if(running){
            timeSeconds++;
            if(timeSeconds == 60){
                timeMinutes++;
                timeSeconds = 0;
            }
            this.setChanged();
            this.notifyObservers();
        }
    }

    public int getTiempoEnSegundos(){
        return timeSeconds + timeMinutes*60;
    }

    public String mostrarEnLabel(){
        String tm = Integer.toString(timeMinutes);
        String ts = Integer.toString(timeSeconds);

        if (timeSeconds < 10) ts = "0" + ts;
        if (timeMinutes < 10) tm = "0" + tm;

        return tm +":"+ ts;
    }

    public void reset(){
        timeMinutes = 0;
        timeSeconds = 0;
        this.setChanged();
        this.notifyObservers("Reloj");
    }

}
