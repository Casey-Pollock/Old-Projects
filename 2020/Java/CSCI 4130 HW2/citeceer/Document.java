/*
 * Casey Pollock
 * CSCI 4130
 * 3/5/2020
 * 
 * This program is used to create and manipulate Document objects.  This 
 * object will consist of the name of a document, the words of a document, 
 * and the similarity it shares with another Document.
 */

package citeceer;

import java.util.*;

public class Document {

	private String name;
	private List<Token> wordList;
	private double similarity;
	
	/*
	 * Document will create a Document object that will store the name of a 
	 * document, the words of a document, and the similarity it shares with 
	 * another Document.
	 */
	public Document(String name) {
		
		this.name = name;
		this.wordList = new ArrayList<Token>();
		this.similarity = 0;
		
	}
	
	/*
	 * Add will add a new word to this documents list of words as a token.  
	 * If the word already exist in the list the number of occurrences in the 
	 * token will be increased.
	 */
	public void add(String word) {
		
		if(this.contains(word)) {
			
			this.getWord(word).newOccurrence();
			
		}
		else {
			
			this.wordList.add(new Token(word));
			
		}
		
	}
	
	/*
	 * GetWords will return the list of the words.
	 */
	public List<Token> getWords(){
		
		return this.wordList;
		
	}
	
	/*
	 * SetSim will set this documents similarity.
	 */
	public void setSim(double d) {
		
		this.similarity = d;
		
	}
	
	/*
	 * GetSim will return this Document's similarity.
	 */
	public double getSim() {
		
		return this.similarity;
		
	}
	
	/*
	 * ClearSim will rest the value of this Document's similarity.
	 */
	public void clearSim() {
		
		this.setSim(0);
		
	}
	
	/*
	 * GetWord will search this Document's word list and find the given word and 
	 * return it. If the word in not found then null will be returned.
	 */
	public Token getWord(String word) {
		
		Iterator<Token> iter = this.wordList.iterator();
		Token toke;
		while(iter.hasNext()) {
			
			toke = iter.next();
			if(toke.equals(word)) {
				
				return toke;
				
			}
			
		}
		return null;
		
	}
	
	/*
	 * GetName will return the name of this Document.
	 */
	public String getName() {
		
		return this.name;
		
	}
	
	/*
	 * Iterator will return an iterator of the list of words that this document holds.
	 */
	public Iterator<Token> iterator(){
		
		return this.wordList.iterator();
		
	}
	
	/*
	 * Contains will check if this Document's word list has a given word. If id 
	 * does true is returned, otherwise false is returned. 
	 */
	public boolean contains(String word) {
		
		Iterator<Token> iter = this.wordList.iterator();
		while(iter.hasNext()) {
			
			if(iter.next().equals(word)) {
				
				return true;
				
			}
			
		}
		return false;
		
	}
	
	/*
	 * ToString will convert a Documents name and word list to a string.  
	 * Mostly used for error checking.
	 */
	public String toString() {
		
		return (this.getName() + "\n" + wordList + "\n");
		
	}
	
}
