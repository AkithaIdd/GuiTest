package com.example.javaobjectsasmethodpara;

public class MyClass {

    public static void main(String[] args) {



        Employer bank = new Employer();

        Employee Jenna = new Employee("Jenna", "Lassoft",
                324587, "HR", "Recruiter", 4500.89);

        Employee Lance = new Employee("Lance", "K.",
                3245377, "IT", "IT/Support", 3800.59);

        bank.calculateAnnualBonus(Jenna);
        bank.calculateAnnualBonus(Lance);
        bank.employeeDetails(Lance);

        boolean related = bank.areRelated(Jenna, Lance);
        System.out.println(related);


    }

}