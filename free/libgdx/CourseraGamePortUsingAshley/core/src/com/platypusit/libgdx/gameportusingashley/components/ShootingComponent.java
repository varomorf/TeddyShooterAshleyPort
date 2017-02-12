package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.audio.Sound;
import com.platypusit.libgdx.gameportusingashley.constant.ProjectileType;

/**
 * <p>Component to allow and entity to shoot projectiles.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class ShootingComponent implements Component {

    public boolean isShooting;
    public ProjectileType projectileType;
    public Sound firingSound;
    public float projectileSpawningYOffset;

}
