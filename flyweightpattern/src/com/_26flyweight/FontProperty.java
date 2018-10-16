package com._26flyweight;

public class FontProperty {
	
	private char letter;
    private int fontSize;
    private String color;
    
    public FontProperty(char letter, int fontSize, String color)
    {
        this.letter = letter;
        this.fontSize = fontSize;
        this.color = color;
    }
    public void display()
    {
        System.out.println(this.letter);
    }

}
