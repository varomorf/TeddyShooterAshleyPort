package com.platypusit.libgdx.gameportusingashley.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.platypusit.libgdx.gameportusingashley.components.DrawableComponent;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.VelocityComponent;

/**
 * Entity for Teddy Bears.
 * Created by alfergon on 30/01/17.
 */
public class TeddyBear extends Entity{

    public static final String TEXTURE_PATH = "graphics/teddybear.png";

    public TeddyBear(Texture texture) {
        add(new PositionComponent(100,100));
        add(new VelocityComponent(10,10));
        add(new DrawableComponent(texture));
    }
}
