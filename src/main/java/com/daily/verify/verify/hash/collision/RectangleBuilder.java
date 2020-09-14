package com.daily.verify.verify.hash.collision;

public class RectangleBuilder {
    private Rectangle rectangle = new Rectangle();

    public static RectangleBuilder getBuilder() {
        return new RectangleBuilder();
    }

    public Rectangle build() {
        return rectangle;
    }

    public RectangleBuilder setName(String name) {
        rectangle.setName(name);
        return this;
    }

    public RectangleBuilder setLength(Float length) {
        rectangle.setLength(length);
        return this;
    }

    public RectangleBuilder setWidth(Float width) {
        rectangle.setWidth(width);
        return this;
    }

}
