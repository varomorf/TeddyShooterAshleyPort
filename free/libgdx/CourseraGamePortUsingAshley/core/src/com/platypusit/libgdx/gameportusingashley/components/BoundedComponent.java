package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;

/**
 * <p>Component for a bounded entity (an entity that cannot go beyond bounds.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class BoundedComponent implements Component {

    public float topBound;
    public float bottomBound;
    public float leftBound;
    public float rightBound;

}
