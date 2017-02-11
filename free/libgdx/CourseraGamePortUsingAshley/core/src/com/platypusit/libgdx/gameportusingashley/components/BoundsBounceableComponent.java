package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;

/**
 * <p>Makes an entity to bounce off some bounds.</p>
 * Created by Alvaro on 11/02/2017.
 */
public class BoundsBounceableComponent implements Component {

    public float topBound;
    public float bottomBound;
    public float leftBound;
    public float rightBound;

}
