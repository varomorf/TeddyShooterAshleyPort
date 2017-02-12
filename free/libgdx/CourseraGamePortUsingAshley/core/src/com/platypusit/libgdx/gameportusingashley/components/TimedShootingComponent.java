package com.platypusit.libgdx.gameportusingashley.components;

/**
 * <p>Component for entities that shoot after a number of seconds have passed.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class TimedShootingComponent extends TimedComponent {

    public TimedShootingComponent(float secondsForShooting) {
        super(secondsForShooting);
    }
}
