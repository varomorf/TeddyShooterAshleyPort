package com.platypusit.libgdx.gameportusingashley;

import com.badlogic.ashley.core.ComponentMapper;
import com.platypusit.libgdx.gameportusingashley.components.*;

/**
 * Mapper for components.
 * Created by alfergon on 30/01/17.
 */
public class ComponentMappers {
    public static final ComponentMapper<PositionComponent> position = ComponentMapper.getFor(PositionComponent.class);
    public static final ComponentMapper<VelocityComponent> velocity = ComponentMapper.getFor(VelocityComponent.class);
    public static final ComponentMapper<DrawableComponent> drawable = ComponentMapper.getFor(DrawableComponent.class);
    public static final ComponentMapper<BoundsBounceableComponent> boundsBounceable = ComponentMapper.getFor(BoundsBounceableComponent.class);
    public static final ComponentMapper<ShootingComponent> shooting = ComponentMapper.getFor(ShootingComponent.class);
}
