package ru.yandex.java.course.third.war;

public class War {
    public static void main(String[] args) {
        Tank tank = new Tank(10, 50);
        Soldier soldier = new Soldier(1, 5);

        tank.move();
        tank.shoot();

        soldier.move();
        soldier.shoot();

        soldier.setTerrain(new RuggedTerrain());

        soldier.move();
        soldier.shoot();

        tank.setTerrain(new RuggedTerrain());

    }
}
