package ru.geekbrains.java_core1.lessons.lesson5_oop;

import java.time.Year;

public class Empoyee {
    private String name;
    private String jobTitle;
    private String email;
    private String phone;
    private int salary;
    private int birthYear;

    public Empoyee(String name, String jobTitle, String email, String phone, int salary, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.birthYear = Year.now().getValue() - age;
    }

    public int getAge() {
        return Year.now().getValue() - birthYear;
    }

    @Override
    public String toString() {
        return String.format("%s Должность: %s e-mail: %s Тел.: %s Зарплата: %d Возраст: %d",
                name, jobTitle, email, phone, salary, getAge());

    }
}
