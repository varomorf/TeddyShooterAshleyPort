package com.platypusit.libgdx.gameportusingashley.components;

import com.badlogic.ashley.core.Component;

/**
 * <p>Component for a UI text.</p>
 * Created by Alvaro on 19/02/2017.
 */
public class UITextComponent implements Component {
    public String text;

    public UITextComponent(String text) {
        this.text = text;
    }
}
