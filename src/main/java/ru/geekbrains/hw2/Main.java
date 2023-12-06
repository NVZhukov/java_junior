package ru.geekbrains.hw2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    /*
        Создайте абстрактный класс "Animal" с полями "name" и "age".
        Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
        Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
        Выведите на экран информацию о каждом объекте.
        Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
     */

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Barsik", 7),
                new Cat("Murzik", 3),
                new Dog("Tuzik", 8),
                new Cat("Asya", 5)
        };

        try {
            getClassInfo(animals);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void getClassInfo(Animal[] animals) throws IllegalAccessException, InvocationTargetException {
        for (Animal animal: animals) {
            Class<?> animalClass = animal.getClass();
            Class<?> superClass = animalClass.getSuperclass();
            System.out.println("Класс: " + animalClass.getSimpleName());
            
            Field[] fields = superClass.getDeclaredFields();

            for (Field field : fields){
                field.setAccessible(true);
                System.out.printf("  %s : %s\n", field.getName(), field.get(animal));
            }

            Field[] animalField = animalClass.getDeclaredFields();

            for (Field field: animalField) {
                field.setAccessible(true);
                System.out.printf("  %s : %s\n", field.getName(), field.get(animal));
            }

            Method[] animalMethods = animalClass.getDeclaredMethods();

            for (Method method: animalMethods) {
                System.out.println("  " + method.getName() + "()");
                if (method.getName().equals("makeSound")) {
                    method.invoke(animal);
                }
            }
        }
    }
}

