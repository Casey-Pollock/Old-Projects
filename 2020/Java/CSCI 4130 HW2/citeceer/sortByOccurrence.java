/*
 * Casey Pollock
 * CSCI 4130
 * 2/6/2020
 * 
 * This program is used to create a Comparator to compare two tokens.
 */

package citeceer;

import java.util.Comparator;

public class sortByOccurrence implements Comparator<Token> {

	@Override
	public int compare(Token o1, Token o2) {
		
		return o2.getOccurrence()-o1.getOccurrence();
	}
	
}

