package com.develogical.camera;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.api.Expectation;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.jmock.internal.Cardinality.exactly;

public class CameraTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {

        final Sensor sense = context.mock(Sensor.class);

         // write your test here
        Camera cam = new Camera(sense);





        context.checking(new Expectations() {{
        exactly(1).of(sense).powerUp();

        }});

        cam.powerOn();
    }

    @Test
    public void switchingTheCameraOffPowersDownTheSensor()
    {

        final Sensor sense = context.mock(Sensor.class);

        // write your test here
        Camera cam = new Camera(sense);





        context.checking(new Expectations() {{
            exactly(1).of(sense).powerDown();

        }});

        cam.powerOff();

    }
    

}
