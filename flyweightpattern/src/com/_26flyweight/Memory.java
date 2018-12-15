package com._26flyweight;

import java.util.HashMap;
import java.util.Map;

public class Memory {

//	private HashMap<Character, FontProperty> items = new HashMap<>();
	private Map<Character, FontProperty> items = new HashMap<>();

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
