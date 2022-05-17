package com.company;

public class Main {

    public static void main(String[] args) {

        Address addressStudent = new Address("Minsk", "Kalvarijskaya", "21A", "3B");
        Address addressTeacher = new Address("Minsk", "Brovk", "1", "149");

        Person testguy = new Person("Vasya", "Pupkin", 1985, addressStudent, "Student");
        System.out.println("Info about student: " + testguy);

        Teacher teacher1 = new Teacher("Vova", "Putler", 1955, addressTeacher, "Teacher", 1, 10);
        System.out.println("Info about teacher: " + teacher1);

        System.out.println("Info about teacher's wage: " + teacher1.getTariff() * teacher1.getHours());

        teacher1.setTariff(12.5);

        System.out.println("Now hourly tariff is " + teacher1.getTariff());
        System.out.println("Now teacher's wage: " + teacher1.getTariff() * teacher1.getHours());

        StudyGroup newgroup = new StudyGroup("New group", 2, teacher1, testguy);
        System.out.println("Info about group: " + newgroup);

        addressStudent.setApartment("126");
        addressTeacher.setApartment("99");

        System.out.println("Info about persons after address change");
        System.out.println("Info about student: " + testguy);
        System.out.println("Info about teacher: " + teacher1);


    }

}
