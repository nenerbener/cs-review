package com._26flyweight;

import java.util.HashMap;

public class Memory {

	private HashMap<Character, FontProperty> items = new HashMap<>();

    public FontProperty lookUp(char letter)
    {
        if (!items.containsKey(letter))
        {
            items.put(letter, new FontProperty(letter,12,"black"));
        }
        return items.get(letter);
    }

    public int totalObjectsMade()
    {
        return items.size();
    }
}
