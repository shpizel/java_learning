package ru.yandex.java.course.third.lesson.war;

public class RuggedTerrain implements Terrain {
    @Override
    public double getSlowFactor() {
        return 0.5;
    }
}
