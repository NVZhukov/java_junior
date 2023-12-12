package ru.geekbrains.hw3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class StudentV1 implements Externalizable {

    private String name;
    private int age;
    private double gpa;

    public StudentV1() {
    }

    public StudentV1(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.getAge());
        out.writeObject(this.getGpa());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = (int) in.readObject();
        gpa = (double) in.readObject();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gpa=").append(gpa);
        sb.append('}');
        return sb.toString();
    }
}
