package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.platypusit.libgdx.gameportusingashley.components.DamagingComponent;
import com.platypusit.libgdx.gameportusingashley.components.DrawableComponent;
import com.platypusit.libgdx.gameportusingashley.components.PlayerComponent;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;

/**
 * <p>System for detecting the collisions between projectiles and its damageable entities and computing its outcome
 * (points if ti's a player projectile the one that hits and health loss if it's the enemy's projectile the one that
 * hits the player).</p>
 * Created by Alvaro on 15/02/2017.
 */
public class ProjectileDamageSystem extends IteratingSystem {

    private static final Family family = Family.all(PositionComponent.class, DrawableComponent.class, DamagingComponent.class).get();

    public ProjectileDamageSystem() {
        super(family);
    }

    public ProjectileDamageSystem(int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        System.out.println(entity.getClass().getName());
    }

}
