/*
 * Casey Pollock
 * CSCI 4130
 * 3/5/2020
 * 
 * This program is used to create and manipulate StopWord objects.  This 
 * object will consist of the starting character of the words and a list of words.
 */

package citeceer;

import java.util.*;

public class StopWords {

	private char firstLetter;
	private List<String> wordList;
	
	/*
	 * StopWords will create a StopWord object.  It will store a given character 
	 * to be the first character of each word for the list.  An empty list 
	 * will also be created.
	 */
	public StopWords(char first) {
		
		this.firstLetter = first;
		this.wordList = new LinkedList<String>();
		
	}
	
	/*
	 * Add will add a new word to the list.
	 */
	public void add(String word) {
		
		this.wordList.add(word);
		
	}
	
	/*
	 * GetFirst will return the character that is to be the first letter of the word.
	 */
	public char getFirst() {
		
		return this.firstLetter;
		
	}
	
	/*
	 * Equals is true if the word list contains a given word, otherwise false is returned.
	 */
	public boolean equals(String word) {
		
		return this.wordList.contains(word);
		
	}
	
	/*
	 * ToString will convert the list of words to a string.  This is mostly used
	 * for error checking.
	 */
	public String toString() {
		
		return (this.wordList.toString() + "\n");
		
	}
	
}
