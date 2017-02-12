package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.PlayerComponent;
import com.platypusit.libgdx.gameportusingashley.components.VelocityComponent;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;

/**
 * <p>System for moving the player's burger.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class PlayerMovementSystem extends EntitySystem {

    private static final Family family = Family.all(PlayerComponent.class).get();

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        // will only be one
        Entity burger = getEngine().getEntitiesFor(family).first();

        VelocityComponent velocity = ComponentMappers.velocity.get(burger);

        // move burger using keyboard
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.y = GameConstants.BURGER_MOVEMENT_AMOUNT;
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocity.y = -GameConstants.BURGER_MOVEMENT_AMOUNT;
        } else {
            velocity.y = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            velocity.x = -GameConstants.BURGER_MOVEMENT_AMOUNT;
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            velocity.x = GameConstants.BURGER_MOVEMENT_AMOUNT;
        } else {
            velocity.x = 0;
        }
    }
}
