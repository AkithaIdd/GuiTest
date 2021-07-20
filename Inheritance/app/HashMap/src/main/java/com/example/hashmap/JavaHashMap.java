package com.example.hashmap;

import java.util.HashMap;

public class JavaHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> gamestats = new HashMap<>();
        gamestats.put("akitha",100);
        gamestats.put("nimal",200);
        gamestats.put("saman",400 );

        System.out.println(gamestats.size());

        for (int itrm: gamestats.values()
             ) {
            System.out.println(itrm);

        }
        System.out.println(gamestats.get(100));

    }
}