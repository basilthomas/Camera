package com.develogical.camera;

public class Camera {


    private Sensor sense;
    private MemoryCard mem;
    Boolean cameraOn;

    public Camera(Sensor sense,MemoryCard mem) {

        this.sense = sense;
        this.mem = mem;
        this.cameraOn = false;
    }

    public void pressShutter() {
        // not implemented
        if(cameraOn) {
            mem.write(sense.readData());
        }
    }


    public void powerOn() {
        // not implemented

        sense.powerUp();
        this.cameraOn = true;
    }

    public void powerOff() {
       // not implemented
        sense.powerDown();
    }
}

