package com.example.inheritance;

import java.util.ArrayList;

public class MyClass {

    public static void main(String[] args) {

//        Person person = new Person("akitha",25);
//
//       // person.age = 23;
//     //   System.out.println(person.age);
//
//        Hero hero = new Hero("Akithaidd", 34, 45);
//
//        hero.setSalary(1000);
//        System.out.println(hero);
//        System.out.println(hero.getName());

        //Array--------------


        //Coding Exercise 10: CODING EXERCISE: Find
//Multiples of Three

//        int[] numbers = {123, 10, 11, 89, 100 ,89, 10, 999};
//
//      //  int reminder = 0;
//
//        for (int i=0; i< numbers.length;i++){
//
//
//            if (numbers[i] % 3 == 0) {
//                System.out.print(numbers[i]);
//            }
//        }

        //ArrayList---------
        ArrayList name = new ArrayList();
        name.add("saman ");
        name.add("akitha ");
        name.add("nimal ");
        name.add("namal");

        for (int i =0 ; i<name.size() ;i++) {

            System.out.println(name.get(i));
        }

        for (Object  n : name){
            System.out.println(n);
        }














//----------------------------------------
//        int[] myArray = {1,4,5,3,1};
//        String[] stringArray = {"a","w","s","d"};
//        int tot = 0;
//        int avg = 0;
//        for (int i =0 ; i<myArray.length ; i++) {
//
//            tot = tot + myArray[i];
//        }
//            avg = tot / myArray.length;
//
//            System.out.println(avg);




//        int a = (myArray.length)+ 1;
//
//       System.out.println("length "+myArray.length);
//        System.out.println(a);
//        System.out.println(stringArray[1]);


        //
    }
}