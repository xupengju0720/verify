package com.daily.verify.verify.hash.collision;

public class Rectangle extends AbstractRectangle{
    public Rectangle() {
    }

    @Override
    public Float getArea() {
        return this.getLength()*this.getWidth();
    }

    /**
     * 故意重写hashCode 直接用面积代替标准的31倍乘散列方式
     * @return
     */
    @Override
    public int hashCode() {
        System.out.println(this.toString());
        return this.getArea().hashCode();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "name='" + super.getName() + '\'' +
                ", length=" + super.getLength() +
                ", width=" + super.getWidth() +
                '}';
    }
}
