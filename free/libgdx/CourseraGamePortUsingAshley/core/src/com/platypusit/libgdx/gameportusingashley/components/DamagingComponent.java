package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;

/**
 * <p>Component for entities that will damage another entity.</p>
 * Created by Alvaro on 15/02/2017.
 */
public class DamagingComponent<T> implements Component {

    /**
     * The amount of damage to be inflicted.
     */
    public int damage;

    /**
     * The component class that the entity can damage.
     */
    public Class<T> damagedComponentClass;

    public DamagingComponent(int damage) {
        this.damage = damage;
    }
}
