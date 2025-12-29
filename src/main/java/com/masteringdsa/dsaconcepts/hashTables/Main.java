package com.masteringdsa.dsaconcepts.hashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        HashTable table = new HashTable();
        table.put(6, "A");
        table.put(8, "B");
        table.put(11, "C");
        table.put(6, "A+");

        table.remove(6);
        table.remove(11);
        System.out.println("done");
    }

    public static char firstNonRepeatingCharacter(String input){

        Map<Character, Integer> map = new HashMap<>();
        var inputChars = input.toCharArray();

        for(var character : inputChars){
            if(map.containsKey(character))
                map.put(character, map.get(character) + 1);
            else{
                map.put(character, 1);
            }
        }

        for(var character : inputChars){
            if(map.get(character) == 1)
                return character;
        }

        return Character.MAX_VALUE;
    }

    public static char firstRepeatedCharacter(String input){

        Set<Character> set = new HashSet<>();
        var inputChars = input.toCharArray();

        for(var ch : inputChars){
            if(!set.contains(ch))
                set.add(ch);
            else
                return ch;
        }

        return Character.MIN_VALUE;
    }
}
