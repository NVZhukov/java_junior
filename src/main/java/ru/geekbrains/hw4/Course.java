package ru.geekbrains.hw4;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")

public class Course {

    private static final String[] titles = new String[] { "Геометрия", "Литература", "Алгебра", "География", "Физика", "Химия", "Русский язык", "Информатика", "Обществознание", "История" };
    private static final Random random = new Random();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "duration")
    private double duration;

    public Course() {
    }

    public Course(int id, String title, double duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Course create(){
        return new Course(titles[random.nextInt(titles.length)], random.nextFloat(2, 5));
    }

    public void updateDuration(){
        duration = random.nextFloat(2, 5);
    }

    public void updateName(){
        title = titles[random.nextInt(titles.length)];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Course{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", duration=").append(duration);
        sb.append('}');
        return sb.toString();
    }
}
