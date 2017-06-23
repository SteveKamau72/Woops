package com.microclinic.woops.models;

/**
 * Created by steve on 6/23/17.
 */

public class MenuItemsObject {
    private String title;
    private int icon;

    public MenuItemsObject(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public int getIcon() {
        return icon;
    }
}
