package com.masteringdsa.dsaconcepts.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExpressionValidator {

    private Stack<Character> stack = new Stack<>();
    private final List<Character> leftBrackets = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public boolean isValidate(String input){

        for(char character : input.toCharArray()){
            if(isLeftBracket(character))
                stack.push(character);

            if(isRightBracket(character)){
                if(stack.empty()) return false;
                var top = stack.pop();
                if(!bracketsMatch(top, character)) return false;
            }
        }

        return stack.empty();
    }

    private boolean isRightBracket(char character) {
        return rightBrackets.contains(character);
    }

    private boolean isLeftBracket(char character) {
        return leftBrackets.contains(character);
    }

    private boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }
}
