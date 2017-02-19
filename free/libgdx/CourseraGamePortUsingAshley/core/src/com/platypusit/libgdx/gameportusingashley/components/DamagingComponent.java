package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;

/**
 * <p>Component for entities that will damage another entity.</p>
 * Created by Alvaro on 15/02/2017.
 */
public class DamagingComponent implements Component {

    /**
     * The amount of damage to be inflicted.
     */
    public int damage;

    /**
     * The component class that the entity can damage.
     */
    public Class<? extends Component> damagedComponentClass;

    public DamagingComponent(int damage, Class<? extends Component> damagedComponentClass) {
        this.damage = damage;
        this.damagedComponentClass = damagedComponentClass;
    }
}
