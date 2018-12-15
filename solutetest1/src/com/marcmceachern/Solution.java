package com.marcmceachern;

class Solution {
    public int lengthOfLastWord(String s) {
    int lastChar = s.length();
    int firstChar =0;
    int wordLength;
    for (int i=lastChar-1; i>=0; i--) {
        firstChar = i; 
        if (s.charAt(i) == ' ') break;
    }
    wordLength = s.length() - firstChar;
    return wordLength;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int wl = s.lengthOfLastWord("The rain in spain");
		System.out.println("word length: " + wl);
	}
}
