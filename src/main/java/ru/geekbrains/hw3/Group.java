package ru.geekbrains.hw3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Group {
    public static final String FILE_JSON = "student.json";
    public static final String FILE_BIN = "student.bin";
    public static final String FILE_XML = "student.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();


    public void addStudent(List<StudentV1> studentV1) {
        saveStudent(FILE_JSON, studentV1);
        saveStudent(FILE_BIN, studentV1);
        saveStudent(FILE_XML, studentV1);
        System.out.println("Новый студент добавлен.");
    }

    public void saveStudent(String fileName, List<StudentV1> studentV1) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), studentV1);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
                    oos.writeObject(studentV1);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), studentV1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<StudentV1> loadStudent(String fileName) {
        List<StudentV1> studentV1s = new ArrayList<>();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    studentV1s = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, StudentV1.class));
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        studentV1s = (List<StudentV1>) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    studentV1s = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, StudentV1.class));
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return studentV1s;
    }

    public void showStudents(List<StudentV1> s) {
        s.stream().forEach(System.out::println);
    }
}
