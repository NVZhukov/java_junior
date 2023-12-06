package ru.geekbrains.hw2;

public class Dog extends Animal{
    private int stamina;

    public Dog(String name, int age) {
        super(name, age);
        this.stamina = 100;
    }

    public int playGame(){
        System.out.printf("Пес %s сбегал за палкой...", getName());
        return stamina -= 10;
    }

    public void makeSound(){
        System.out.printf("  %s погавкал\n", getName());
    }
}
