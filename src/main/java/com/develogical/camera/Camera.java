package com.develogical.camera;

public class Camera {


    private Sensor sense;

    public Camera(Sensor sense) {

        this.sense = sense;
    }

    public void pressShutter() {
        // not implemented
    }

    public void powerOn() {
        // not implemented

        sense.powerUp();
    }

    public void powerOff() {
       // not implemented
    }
}

