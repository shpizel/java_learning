package ru.yandex.java.course.third.lesson.war;

public class Tank {

    private int power;
    private int speed;
    private Terrain terrain;

    public Tank(int power, int speed) {
        this.power = power;
        this.speed = speed;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public void shoot() {
        System.out.println(this.getClass().getSimpleName() + " shooting with power: " + power);
    }

    public void move() {
        System.out.println(this.getClass().getSimpleName() + " moving to " + speed * terrain.getSlowFactor());
    }
}
