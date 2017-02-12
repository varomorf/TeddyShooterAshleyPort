package com.platypusit.libgdx.gameportusingashley.components.factory;

import com.platypusit.libgdx.gameportusingashley.components.BoundedComponent;
import com.platypusit.libgdx.gameportusingashley.components.BoundsBounceableComponent;
import com.platypusit.libgdx.gameportusingashley.constant.GameConstants;

/**
 * <p>Factory for {@link BoundsBounceableComponent}.</p>
 * Created by Alvaro on 12/02/2017.
 */
public class BoundedComponentFactory {

    public static final BoundedComponent worldBoundedComponent = createWorldBoundedComponent();

    /**
     * <p>Creates a new {@link BoundsBounceableComponent} with the window limits as bounds.</p>
     *
     * @return The created component.
     */
    public static BoundedComponent createWorldBoundedComponent() {
        BoundedComponent component = new BoundedComponent();

        setWorldBounds(component);

        return component;
    }

    /**
     * <p>Sets window limits as bounds for a {@link BoundsBounceableComponent}.</p>
     *
     * @return The created component.
     */
    public static void setWorldBounds(BoundedComponent component) {
        component.bottomBound = 0;
        component.leftBound = 0;
        component.topBound = GameConstants.WINDOW_HEIGHT;
        component.rightBound = GameConstants.WINDOW_WIDTH;
    }
}
