package ru.geekbrains.hw2;

public class Cat extends Animal{
    private int liveCount;

    public Cat(String name, int age) {
        super(name, age);
        liveCount = 9;
    }

    public int getLiveCount() {
        return liveCount;
    }

    public void makeSound(){
        System.out.printf("  %s помяукал\n", getName());
    }
}
