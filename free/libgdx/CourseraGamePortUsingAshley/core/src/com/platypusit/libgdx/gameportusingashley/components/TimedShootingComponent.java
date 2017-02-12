package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;

/**
 * <p>Component for entities that shoot after a number of seconds have passed.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class TimedShootingComponent implements Component {

    public float timer;
    public float secondsForShooting;

    public TimedShootingComponent(float secondsForShooting) {
        this.secondsForShooting = secondsForShooting;
    }
}
