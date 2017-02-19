package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.DrawableComponent;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.UITextComponent;

/**
 * <p>System for drawing UIComponents.</p>
 * Created by Alvaro on 19/02/2017.
 */
public class UIDrawingSystem extends IteratingSystem {

    private static final Family family = Family.all(PositionComponent.class, UITextComponent.class).get();

    private SpriteBatch batch;
    private BitmapFont bitmapFont = new BitmapFont();

    public UIDrawingSystem(SpriteBatch batch) {
        super(family);
        this.batch = batch;
    }

    public UIDrawingSystem(int priority, SpriteBatch batch) {
        super(family, priority);
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = ComponentMappers.position.get(entity);
        UITextComponent uiText = ComponentMappers.uiText.get(entity);

        bitmapFont.draw(batch, uiText.text, position.x, position.y);
    }
}
