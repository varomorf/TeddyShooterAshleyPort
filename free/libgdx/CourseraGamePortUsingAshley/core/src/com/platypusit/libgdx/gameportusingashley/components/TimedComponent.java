package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;

/**
 * <p>Base component for components that model a timed action in seconds.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class TimedComponent implements Component {

    public float timer;
    public float secondsForShooting;

    public TimedComponent(float secondsForShooting) {
        this.secondsForShooting = secondsForShooting;
    }
}
