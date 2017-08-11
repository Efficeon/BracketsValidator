package com.bracketsvalidator;

import java.util.*;

public class BracketsValidator {
    private final Map<Character, Character> brackets = new HashMap<>(3);

    public BracketsValidator() {
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put(')', '(');
    }

    public boolean verify(String line) {

        Set<Character> closedBrackets = brackets.keySet();
        Collection<Character> openBrackets = brackets.values();

        Deque<Character> charsStack = new ArrayDeque<>();
        for (char character : line.toCharArray()){
            if(openBrackets.contains(character)){
                charsStack.push(character);
            } else
            if(closedBrackets.contains(character)){
                Character lastBracket = charsStack.peek();
                if(lastBracket == null)
                    return false;

                if(lastBracket.equals(brackets.get(character))){
                    charsStack.pop();
                }
            }
        }

        return charsStack.isEmpty();
    }
}
