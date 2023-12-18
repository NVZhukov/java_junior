package ru.geekbrains.hw4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:13306";
        String user = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            createDatabase(connection);
            System.out.println("Database created successfully");

            useDatabase(connection);
            System.out.println("Use database successfully");

            createTable(connection);
            System.out.println("Create table successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }


        CourseDao courseDao = new CourseDao();

        Course course = Course.create();

        List<Course> courses = courseDao.findAll();
        if (!courses.isEmpty()) {
            for (Course c : courses) {
                courseDao.deleteData(c);
            }
        } else {
            courseDao.saveData(course);
        }

        Course newCourse = courseDao.findById(course.getId());
        System.out.println("Восстановленный курс: " + newCourse);

        newCourse.updateName();
        newCourse.updateDuration();
        courseDao.updateData(newCourse);
    }

    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS schoolDB;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = "USE schoolDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS courses (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(45), duration FLOAT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }
}
