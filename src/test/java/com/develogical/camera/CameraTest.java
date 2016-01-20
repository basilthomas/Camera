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


    final Sensor sense = context.mock(Sensor.class);
    final MemoryCard mem = context.mock(MemoryCard.class);

    // write your test here
    Camera cam = new Camera(sense,mem);


    @Test
    public void switchingTheCameraOnPowersUpTheSensor() {

        context.checking(new Expectations() {{
        exactly(1).of(sense).powerUp();

        }});

        cam.powerOn();
    }

    @Test
    public void switchingTheCameraOffPowersDownTheSensor()
    {

        context.checking(new Expectations() {{
            exactly(1).of(sense).powerDown();

        }});

        cam.powerOff();

    }

    @Test
    public void pressingTheShutterWhenPowerIsOffDoesNothing()
    {



        context.checking(new Expectations() {{
            exactly(0).of(sense).readData();

        }});

        cam.pressShutter();



    }

    @Test
    public void pressingTheShutterWhenPowerIsOnReadsDataAndWritesToMemoryCard()
    {

        final byte[] imagedata = new byte[5];

        context.checking(new Expectations() {{
            exactly(1).of(sense).powerUp();

        }});
        context.checking(new Expectations() {{
            exactly(1).of(sense).readData();
            will(returnValue(imagedata));
        }});


        context.checking(new Expectations() {{

            exactly(1).of(mem).write(imagedata);

        }});

        cam.powerOn();
        cam.pressShutter();



    }

}
