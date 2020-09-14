package com.daily.verify.verify.hash.collision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 测试hashSet 和hashMap的 hash碰撞问题
 */
public class Test {
    public static void testHashSet() {
        Rectangle r1 = RectangleBuilder.getBuilder().setName("a").setLength(10f).setWidth(5f).build();
        Rectangle r2 = RectangleBuilder.getBuilder().setName("a").setLength(5f).setWidth(10f).build();
        Rectangle r3 = RectangleBuilder.getBuilder().setName("a").setLength(5f).setWidth(10f).build();
        Set<Rectangle> rectangleSet = new HashSet<>();
        rectangleSet.add(r1);
        rectangleSet.add(r2);
        rectangleSet.add(r3);
        System.out.println("rectangleSet" + rectangleSet);
        System.out.println(r2 == r3);
        System.out.println(r1.getArea().hashCode());
    }

    public static void testHashMap() {
        Rectangle r1 = RectangleBuilder.getBuilder().setName("a").setLength(10f).setWidth(5f).build();
        Rectangle r2 = RectangleBuilder.getBuilder().setName("a").setLength(5f).setWidth(10f).build();
        Rectangle r3 = RectangleBuilder.getBuilder().setName("a").setLength(5f).setWidth(10f).build();
        Map<Rectangle, String> rectangleMap = new HashMap<>();
        rectangleMap.put(r1, "元素1");
        rectangleMap.put(r2, "元素2");
        rectangleMap.put(r3, "元素3");
        System.out.println("rectangleMap" + rectangleMap);
    }

    public static void main(String[] args) {
        testHashMap();
    }
}
