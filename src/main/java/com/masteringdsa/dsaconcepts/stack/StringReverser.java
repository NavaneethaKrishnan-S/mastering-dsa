package com.masteringdsa.dsaconcepts.stack;

import java.util.Stack;

public class StringReverser {
    private Stack<Character> stack = new Stack<>();

    public String reverse(String input){

        for(var ch : input.toCharArray())
            stack.push(ch);

        StringBuffer result = new StringBuffer();

        while (!stack.empty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

}
