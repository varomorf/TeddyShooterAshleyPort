package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.ShootingComponent;
import com.platypusit.libgdx.gameportusingashley.components.TimedShootingComponent;

/**
 * <p>System for checking when a timed shooter must shoot.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class TimedShootingSystem extends IteratingSystem {

    private static final Family family = Family.all(ShootingComponent.class, TimedShootingComponent.class).get();

    public TimedShootingSystem() {
        super(family);
    }

    public TimedShootingSystem(int priority) {
        super(family, priority);
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        TimedShootingComponent timer = ComponentMappers.timedShooting.get(entity);

        timer.timer += deltaTime;
        if (timer.timer >= timer.secondsForShooting) {
            // make shooter shoot
            ComponentMappers.shooting.get(entity).isShooting = true;

            // reset timer
            timer.timer = 0;
        }
    }
}
