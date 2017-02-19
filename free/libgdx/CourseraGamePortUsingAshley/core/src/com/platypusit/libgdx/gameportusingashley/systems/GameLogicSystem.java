package com.platypusit.libgdx.gameportusingashley.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.platypusit.libgdx.gameportusingashley.ComponentMappers;
import com.platypusit.libgdx.gameportusingashley.components.DamageableComponent;
import com.platypusit.libgdx.gameportusingashley.components.PlayerComponent;
import com.platypusit.libgdx.gameportusingashley.components.PositionComponent;
import com.platypusit.libgdx.gameportusingashley.components.UITextComponent;
import com.platypusit.libgdx.gameportusingashley.entities.Burger;

import static com.platypusit.libgdx.gameportusingashley.constant.GameConstants.*;

/**
 * <p>This system is the one that must compute the actual game logic: points, loosing, wining, etc...</p>
 * Created by Alvaro on 19/02/2017.
 */
public class GameLogicSystem extends EntitySystem {

    private Entity healthUIText;
    private Entity pointsUIText;
    private UITextComponent healthUITextComponent = new UITextComponent(HEALTH_PREFIX + BURGER_INITIAL_HEALTH);
    private UITextComponent pointsUITextComponent = new UITextComponent(SCORE_PREFIX + 0);

    private Entity burger;
    private DamageableComponent burgerHealth;

    public GameLogicSystem() {
        healthUIText = new Entity();
        healthUIText.add(new PositionComponent(HEALTH_LOCATION.x, HEALTH_LOCATION.y));
        healthUIText.add(healthUITextComponent);

        pointsUIText = new Entity();
        pointsUIText.add(new PositionComponent(SCORE_LOCATION.x, SCORE_LOCATION.y));
        pointsUIText.add(pointsUITextComponent);

    }

    @Override
    public void addedToEngine(Engine engine) {
        engine.addEntity(healthUIText);
        engine.addEntity(pointsUIText);

        burger = engine.getEntitiesFor(Family.one(PlayerComponent.class).get()).first();
        burgerHealth = ComponentMappers.damageable.get(burger);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);

        healthUITextComponent.text = HEALTH_PREFIX + burgerHealth.health;
    }
}
