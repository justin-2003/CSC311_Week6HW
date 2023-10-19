package com.example.csc311_week6hw;

public class Person {

    //variables for the Person class
    private String name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private int salary;
    private int id;


    // default constructor for Person
    public Person() {
        this.setId(0);
        this.name = " ";
        this.email = " ";
        this.phone = " ";
        this.address = " ";
        this.password = " ";
        this.salary = 0;
    }

    // Method to add a new Person to the database
    public Person(String name, String email, String phone, String address, int salary, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setPhone(phone);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String number) {
        this.phone = number;
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

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

