package ru.yandex.java.course.first.homework.MyList;

public class GenericTest {

    public static void main(String[] args) {
        MyListGeneric<String> myList = new MyListGeneric<>(1);
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");
        System.out.println(myList.toString());
    }
}
