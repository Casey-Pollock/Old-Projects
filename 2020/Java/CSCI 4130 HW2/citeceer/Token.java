/*
 * Casey Pollock
 * CSCI 4130
 * 3/5/2020
 * 
 * This will create and manipulates of a Token object.  This object will 
 * consist of a word, a number of documents the word is used in and a 
 * number of occurrences.
 */

package citeceer;

public class Token {
	
	private String word;
	private int occur;
	private int docOccur;
	
	/*
	 * Token will create a Token object that stores a word with one occurrence and one document.
	 */
	public Token (String word) {
		
		this.occur=1;
		this.word=word;
		this.docOccur = 1;
		
	}
	
	/*
	 * Token will create a Token object that stores a word and a given of occurrences..
	 */
	public Token (String word, int occur) {
		
		this.occur = occur;
		this.word = word;
		
	}
	
	/*
	 * NewDoc will add one to the number of Document occurrences.
	 */
	public void newDoc() {
		
		this.docOccur++;
		
	}
	
	/*
	 * SetOccurrence will set the current tokens occurrence to occur.
	 */
	public void setOccurrence(int occur) {
		
		this.occur = occur;
		
	}
	
	/*
	 * GetOccurence will return the the number of occurrences stored 
	 * in a Token.
	 */
	public int getOccurrence() {
		
		return this.occur;
		
	}
	
	/*
	 * GetDocOccur will return the number of documents this word has occurred in.
	 */
	public int getDocOccur() {
		
		return this.docOccur;
		
	}
	
	/*
	 * GetWord will return the word that is stored in a Token.
	 */
	public String getWord() {
		
		return this.word;
		
	}
	
	/*
	 * NewOccurrence will add one to the current number of occurrences 
	 * held in this Token.
	 */
	public void newOccurrence() {
		
		this.occur++;
		
	}
	
	/*
	 * Equals will return true if the word in this Token matches the given word.
	 */
	public boolean equals(String temp) {
		
		return this.word.equalsIgnoreCase(temp);
		
	}
	
	/*
	 * CompareTo to will compare the word in this Token with a given word.
	 */
	public int compareTo(String obj) {
		
		String tokestr = getWord();
		return tokestr.compareToIgnoreCase(obj);
		
	}
	
	/*
	 * CompareTo to will compare the word in this Token with the word in a given Token.
	 */
	public int compareTo(Token toke) {
		
		return this.word.compareToIgnoreCase(toke.word);
		
	}
	
	/*
	 * ToString converts a Token to a string.
	 */
	public String toString() {
		
		return (this.word + " " + this.occur);
		
	}

}
