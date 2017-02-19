package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.*;

import java.awt.*;

/**
 * <p>System for detecting the collisions between projectiles and its damageable entities and computing its outcome
 * (points if ti's a player projectile the one that hits and health loss if it's the enemy's projectile the one that
 * hits the player).</p>
 * Created by Alvaro on 15/02/2017.
 */
public class ProjectileDamageSystem extends IteratingSystem {

    private static final Family family = Family.all(PositionComponent.class, DrawableComponent.class, DamagingComponent.class).get();

    private DamagingComponent damaging;
    private PositionComponent position;
    private DrawableComponent drawable;
    private Rectangle damagingRectangle = new Rectangle();

    private PositionComponent targetPosition;
    private DrawableComponent targetDrawable;
    private Rectangle targetRectangle = new Rectangle();

    public ProjectileDamageSystem() {
        super(family);
    }

    public ProjectileDamageSystem(int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        damaging = ComponentMappers.damaging.get(entity);
        position = ComponentMappers.position.get(entity);
        drawable = ComponentMappers.drawable.get(entity);

        damagingRectangle.setBounds((int)position.x, (int)position.y, drawable.texture.getWidth(), drawable.texture.getHeight());

        Family targetFamily = Family.all(PositionComponent.class, DrawableComponent.class, DamageableComponent.class, damaging.damagedComponentClass).get();
        for (Entity target : getEngine().getEntitiesFor(targetFamily)) {
            targetPosition = ComponentMappers.position.get(target);
            targetDrawable = ComponentMappers.drawable.get(target);

            targetRectangle.setBounds((int)targetPosition.x, (int)targetPosition.y, targetDrawable.texture.getWidth(), targetDrawable.texture.getHeight());
            if(damagingRectangle.intersects(targetRectangle)){
                // damage the target
                ComponentMappers.damageable.get(target).health -= damaging.damage;

                // remove the projectile to stop it from damaging more entities
                getEngine().removeEntity(entity);
            }
        }
    }

}
