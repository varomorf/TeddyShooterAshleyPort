package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.platypusit.libgdx.gameportusingashley.components.*;
import com.platypusit.libgdx.gameportusingashley.components.factory.BoundedComponentFactory;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;

import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.*;
import static com.platypusit.libgdx.gameportusingashley.constant.ProjectileType.FRENCH_FRIES;

/**
 * <p>Entity for the player's burger.</p>
 * <p>Initially it will be centered on X and on the lower 20% of the window and with 0 speed.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class Burger extends Entity {

    public Burger(Texture texture, Sound firingSound) {
        add(new PositionComponent(WINDOW_WIDTH / 2, WINDOW_HEIGHT * 0.2f));
        add(new VelocityComponent(0, 0));
        add(new DrawableComponent(texture));
        add(new PlayerComponent());
        add(new ShootingComponent(FRENCH_FRIES, FRENCH_FRIES_PROJECTILE_OFFSET, firingSound));
        add(BoundedComponentFactory.worldBoundedComponent);
        add(new DamageableComponent(GameConstants.BURGER_INITIAL_HEALTH));
    }
}
