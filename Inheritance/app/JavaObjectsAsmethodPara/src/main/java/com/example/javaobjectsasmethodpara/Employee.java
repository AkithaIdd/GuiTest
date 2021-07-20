package com.example.javaobjectsasmethodpara;

public class Employee {

    private String firstName;
    private String lastName;
    private int idNum;
    private String department;
    private String position;
    private double monthlySalary;

    public Employee(String firstName, String lastName, int idNum, String department, String position, double monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNum = idNum;
        this.department = department;
        this.position = position;
        this.monthlySalary = monthlySalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
