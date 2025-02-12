package ru.geekbrains.java_core1.lessons.lesson6_oop_inheritance;

/*1. Создать классы Собака и Кот с наследованием от класса Животное.
  2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
     Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал
     150 м.');
  3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет
     плавать, собака 10 м.).
  4* Добавить подсчет созданных котов, собак и животных.*/

public class Homework6_oop_inheritance {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Vaska"),
                new Dog("Sharik"),
                new Dog("Bobik")
                };

        for (int i = 0; i < animals.length; i++) {
            animals[i].run(100);
            animals[i].swim(10);
        } System.out.printf("В нашем зоопарке %d животных\n", animals.length);
    }
}
