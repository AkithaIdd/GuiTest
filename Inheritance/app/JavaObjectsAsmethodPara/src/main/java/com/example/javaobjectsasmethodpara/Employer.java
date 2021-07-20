package com.example.javaobjectsasmethodpara;

public class Employer {
    private String name;
    private String location;

    public Employer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Employer() {
    }

    public boolean areRelated(Employee employeeA, Employee employeeB) {
        if (employeeA.getLastName() == employeeB.getLastName()) {
            return true;
        }else
            return false;
    }
    public void calculateAnnualBonus(Employee employee) {
        double annualBonus = (employee.getMonthlySalary() * 0.15) * 11;
        System.out.println("Annual bonus for " + employee.getFirstName() + " is " + annualBonus);


    }


    public void employeeDetails(Employee employee) {

        System.out.println("ID: " + employee.getIdNum()
                + " Name: " + employee.getFirstName() + " " + employee.getLastName()
                + " Department: " + employee.getDepartment() +
                " Position: " + employee.getPosition()
                + " Monthly Salary: " + employee.getMonthlySalary());


    }
}
