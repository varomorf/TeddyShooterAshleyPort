package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.platypusit.libgdx.gameportusingashley.components.DrawableComponent;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.VelocityComponent;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;

/**
 * <p>Entity for the player's burger.</p>
 * <p>Initially it will be centered on X and on the lower 20% of the window and with 0 speed.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class Burger extends Entity {

    public Burger(Texture texture) {
        add(new PositionComponent(GameConstants.WINDOW_WIDTH / 2, GameConstants.WINDOW_HEIGHT * 0.2f));
        add(new VelocityComponent(0, 0));
        add(new DrawableComponent(texture));
    }
}
