package com.example.csc311_week6hw;

public class Person {

    private String name;
    private String email;
    private String number;
    private String address;
    private String password;
    private int salary;


    public Person() {
        this.name = " ";
        this.email = " ";
        this.number = " ";
        this.address = " ";
        this.password = " ";
        this.salary = 0;
    }


    public Person(String name, String email, String number, String address, int salary, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setNumber(number);
        this.setAddress(address);
        this.password = password;
        this.setSalary(salary);
    }

    // fix the getters and setters to match the fields

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

