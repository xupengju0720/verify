package com.daily.verify.verify.hash.collision;

import lombok.Data;

@Data
public abstract class AbstractRectangle implements Shape {
    private String name;
    private Float length;
    private Float width;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRectangle that = (AbstractRectangle) o;
        if (!name.equals(that.name)) return false;
        if (!length.equals(that.length)) return false;
        return width.equals(that.width);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + length.hashCode();
        result = 31 * result + width.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AbstractRectangle{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
