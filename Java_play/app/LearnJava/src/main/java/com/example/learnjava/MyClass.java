package com.example.learnjava;

public class  MyClass {
    public static void main(String[] args) {
//        String name = "Akitha";
//        int age = 23;
//        long year = 25463563437l ;
//        byte byt = 122;
//
//
//        System.out.println("Hello World! " + name + " age = "+ age);
//        System.out.println(year);


//        double a = 20;
//        double b = 12;
//
//        float div = (float) (a/b);
//        double rei = a%b;
//
//        System.out.println(rei);
//        int a =10;
//        int b = 20;

        // if-else
//
//        if (a == b){
//            System.out.println("running");
//        }else {
//            System.out.println("not running");
//        }



//        int age  = 18;
//        boolean isCitizen = true;
//
//        if ((age >= 18) || (isCitizen)){
//            System.out.println("can vote");
//        }else {
//            System.out.println("can not");
//        }

        //for loop
//        for (int i = 0; i < 10; ++i) {
//            System.out.println(i);
//            int a = 20;
//            if (a == 0){
//
//            }{
//
//            }
//
//        }
//

        //switch

//        String command = "deposite";
//        int balance = 1000;
//        int amount = 100;
//
//
//        switch (command){
//
//
//            case "withdraw": {
//
//                int bln = balance - amount;
//
//                System.out.println("Your balance used to be " + balance + " , and now is " + bln);
//                break;
//            }
//            case "deposite": {
//                int blns = balance + amount;
//
//                System.out.println("Your balance used to be " + balance + " , and now is " + blns);
//                break;
//            }
//
//        }

        // do-while


//        int limit = 10;
//        int count = 10;
//
//        do {
//            System.out.println("counting");
//            count++;
//        }while (limit < count);
        anotherMethod("world", 3, 2.2);
        System.out.println(anotherMethodint(2, 5));

        anotherMethodchar("A");

        //exercise


        System.out.println("Area is "+ recArea(10, 19));





    }
// Multiple Args
    public static void anotherMethod(String word , int num , double dub){

        System.out.println("Hello "+ word + num + dub);
    }

    // Return types
    public static int anotherMethodint(int no1, int no2){

        int sum = no1 + no2;

        return sum;

    }
    public static void anotherMethodchar(String cha){

        System.out.println("Hello "+ cha);
    }

    // exercise

    public static int recArea(int width, int len){
        int area = width * len;
        if (area <0){
            return -area;
        }
        return area;
    }
}