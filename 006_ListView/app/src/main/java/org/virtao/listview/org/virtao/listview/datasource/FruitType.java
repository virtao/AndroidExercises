package org.virtao.listview.org.virtao.listview.datasource;

/**
 * Created by Virtao on 15/10/13.
 */
public class FruitType {
    private String name;

    private int imageId;

    public FruitType(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
