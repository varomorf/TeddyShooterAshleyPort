package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;

/**
 * <p>Component to hold information of damageable components.</p>
 * <p>They will have health to represent the maximum amount of damage they can take.</p>
 * Created by Alvaro on 19/02/2017.
 */
public class DamageableComponent implements Component{

    public int health;
}
