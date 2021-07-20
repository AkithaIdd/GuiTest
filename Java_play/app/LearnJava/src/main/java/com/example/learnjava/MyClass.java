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
//        anotherMethod("world", 3, 2.2);
//        System.out.println(anotherMethodint(2, 5));
//
//        anotherMethodchar("A");
//
//        //exercise
//
//
//        System.out.println("Area is "+ recArea(10, 19));
//
//
//
//
//
//    }
//// Multiple Args
//    public static void anotherMethod(String word , int num , double dub){
//
//        System.out.println("Hello "+ word + num + dub);
//    }
//
//    // Return types
//    public static int anotherMethodint(int no1, int no2){
//
//        int sum = no1 + no2;
//
//        return sum;
//
//    }
//    public static void anotherMethodchar(String cha){
//
//        System.out.println("Hello "+ cha);
//    }
//
//    // exercise
//
//    public static int recArea(int width, int len){
//        int area = width * len;
//        if (area <0){
//            return -area;
//        }
//        return area;
        //create objects
        Microphone microphone = new Microphone("ABC","RED",123);
        Microphone microphone1 = new Microphone("XZY","BLUE",456);
        Microphone microphone2 = new Microphone();

        microphone2.setColor("black");

        microphone.setName("ABCD");
     //   microphone.setColor();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("im akitha  ");
        stringBuilder.append("25 years old");

        System.out.println(stringBuilder);

        System.out.println(microphone.getName());
        System.out.println(microphone1.getColor());
        System.out.println(microphone1.getModel());
        System.out.println(microphone2.getColor() );




//        microphone.name = "ABC";
//        microphone.color = "RED";
//        microphone.model = 123;
//
//        microphone1.name = "XZY";
//        microphone1.color = "BLUE";
//        microphone1.model = 456;

        //calling methods
//        microphone.turnOn();
//        microphone1.setVolume();
    }
}