package com.platypusit.libgdx.gameportusingashley.components.factory;

import com.platypusit.libgdx.gameportusingashley.components.BoundsBounceableComponent;

/**
 * <p>Factory for {@link BoundsBounceableComponent}.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class BoundsBounceableComponentFactory {

    public static final BoundsBounceableComponent worldBounceableComponent = createWorldBounceableComponent();

    /**
     * <p>Creates a new {@link BoundsBounceableComponent} with the window limits as bounds.</p>
     *
     * @return The created component.
     */
    public static BoundsBounceableComponent createWorldBounceableComponent() {
        BoundsBounceableComponent component = new BoundsBounceableComponent();

        BoundedComponentFactory.setWorldBounds(component);

        return component;
    }
}
