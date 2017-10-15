package ru.yandex.java.course.third.war;

public class Soldier {

    private int power;
    private int speed;
    private Terrain terrain;

    public Soldier(int power, int speed) {
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
