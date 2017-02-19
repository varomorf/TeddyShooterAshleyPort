package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.platypusit.libgdx.gameportusingashley.components.DamagingComponent;
import com.platypusit.libgdx.gameportusingashley.components.DrawableComponent;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.VelocityComponent;

/**
 * <p>Entity for generic projectiles.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class Projectile<T> extends Entity{

    public Projectile(float x, float y, float ySpeed, Texture projectileTexture, int damage, Class<? extends Component> damagedComponentClass) {
        add(new PositionComponent(x, y));
        add(new VelocityComponent(0, ySpeed));
        add(new DrawableComponent(projectileTexture));
        add(new DamagingComponent(damage, damagedComponentClass));
    }
}
