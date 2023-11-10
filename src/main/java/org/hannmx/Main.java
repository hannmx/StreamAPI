package org.hannmx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Иван", Arrays.asList(4.5, 3.5, 5.0), "Программирование"),
                new Student("Виктория", Arrays.asList(4.5, 4.5, 5.0), "Математика"),
                new Student("Павел", Arrays.asList(3.5, 3.5, 3.0), "Физика"),
                new Student("Дмитрий", Arrays.asList(5.0, 4.5, 5.0), "Программирование"),
                new Student("Елена", Arrays.asList(4.5, 3.5, 2.0), "Математика"),
                new Student("Максим", Arrays.asList(4.5, 5.0, 5.0), "Программирование")
        );

        List<Student> result = students.stream()
                .filter(student -> student.getSpecialty().equals("Программирование"))
                .filter(student -> student.getAverageGrade() > 4.5)
                .sorted((s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade()))
                .limit(5)
                .collect(Collectors.toList());

        result.forEach(student -> System.out.println(student.getName() + ": " + student.getAverageGrade()));
    }
}