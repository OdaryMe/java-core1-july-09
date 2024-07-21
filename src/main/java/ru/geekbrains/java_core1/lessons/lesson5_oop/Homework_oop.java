package ru.geekbrains.java_core1.lessons.lesson5_oop;

public class Homework_oop {
    public static void main(String[] args) {
        Empoyee[] emplArray = new Empoyee[5];
        emplArray[0] = new Empoyee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231231452", 150000, 30);
        emplArray[1] = new Empoyee("Petrov Petr", "Programmer", "ppetrov@mailbox.com", "89654782146", 250000, 36);
        emplArray[2] = new Empoyee("Sidorov Savva", "Accountant", "ssidorov@mailbox.com", "89653154215", 100000, 56);
        emplArray[3] = new Empoyee("Fomin Anton", "Manager", "afomin@mailbox.com", "89654142588", 75000, 41);
        emplArray[4] = new Empoyee("Lukin Ilya", "Designer", "ilukin@mailbox.com", "89256984157", 120000, 48);

        System.out.println("Сотрудники старше 40 лет:");
        for (int i = 0; i < emplArray.length; i++) {
            if(emplArray[i].getAge() > 40){
                System.out.println(emplArray[i]);
            }
        }
    }
}

