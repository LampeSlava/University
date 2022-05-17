package com.company;

public class Person {
    private String name;
    private String surname;
    private int yearBirth;
    private Address address;
    private String status; //student, teacher, etc.

    //constructors
    public Person(String name, String surname, int yearBirth, Address address, String status) {
        this.name = name;
        this.surname = surname;
        this.yearBirth = yearBirth;
        this.address = address;
		/*if ((status != "Teacher") || (status != "Student")) {
			this.status = "Student";
		} else {*/
        this.status = status;
        //}
    }

    public Person(String name, String surname, int yearBirth, Address address) {
        this.name = name;
        this.surname = surname;
        this.yearBirth = yearBirth;
        this.address = address;
        this.status = "Student"; //create default
    }

    //setters and getters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setYear(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public int getYear() {
        return this.yearBirth;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getSurname() + ", " + this.getYear() + ", " + this.getStatus() + ", address: " + this.address;
    }

}
