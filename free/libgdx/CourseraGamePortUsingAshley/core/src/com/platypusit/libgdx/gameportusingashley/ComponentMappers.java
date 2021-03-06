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
    public static final ComponentMapper<BoundedComponent> bounds = ComponentMapper.getFor(BoundedComponent.class);
    public static final ComponentMapper<ShootingComponent> shooting = ComponentMapper.getFor(ShootingComponent.class);
    public static final ComponentMapper<TimedShootingComponent> timedShooting = ComponentMapper.getFor(TimedShootingComponent.class);
    public static final ComponentMapper<DamagingComponent> damaging = ComponentMapper.getFor(DamagingComponent.class);
    public static final ComponentMapper<DamageableComponent> damageable = ComponentMapper.getFor(DamageableComponent.class);
    public static final ComponentMapper<UITextComponent> uiText = ComponentMapper.getFor(UITextComponent.class);
}
