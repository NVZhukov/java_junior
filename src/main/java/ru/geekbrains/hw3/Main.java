package ru.geekbrains.hw3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student student = new Student("Alexey", 18, 4.8);

        try (FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(student);
        }

        try (FileInputStream fileInputStream = new FileInputStream("student.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                student = (Student) objectInputStream.readObject();
        }

        System.out.println("Объект Student десериализован.");
        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл: " + student.getGPA());


        List<StudentV1> s = new ArrayList<>();

        StudentV1 s1 = new StudentV1("Ivan", 22,5.0);
        StudentV1 s2 = new StudentV1("Max", 23,4.9);
        s.add(s1);
        s.add(s2);

        Group group = new Group();
        group.addStudent(s);
        group.loadStudent("student.xml");
        group.showStudents(s);
    }
}
