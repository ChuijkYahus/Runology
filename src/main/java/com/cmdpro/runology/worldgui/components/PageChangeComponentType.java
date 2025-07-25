package com.cmdpro.runology.worldgui.components;

import com.cmdpro.databank.worldgui.WorldGui;
import com.cmdpro.databank.worldgui.components.WorldGuiComponent;
import com.cmdpro.databank.worldgui.components.types.WorldGuiButtonComponentType;

public class PageChangeComponentType extends WorldGuiButtonComponentType {
    @Override
    public WorldGuiComponent createComponent(WorldGui worldGui) {
        return new PageChangeComponent(worldGui, 0, 0, false);
    }
}