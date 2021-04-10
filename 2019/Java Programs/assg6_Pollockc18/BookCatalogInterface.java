/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This interface will be used in conjunction with the 
 * BookCatalog class to manipulate a list of Book object.
*/


package assg6_Pollockc18;

import java.io.*;
import java.util.*;

public interface BookCatalogInterface {

	/*This method will load Books from a given document, str.
	 * The Books will be placed into an ArrayList that can be 
	 * used at a later time.  The initial list should be in 
	 * alphabetical order.  The data in the document should be 
	 * as follows:
	 * 
	 * 		ISBN
	 * 		Title
	 * 		Author
	 *		Publisher
	 *		Published Year
	 * 		Empty Line
	 * 
	 * @param str 					 The location of the file 
	 * 								 that will be loaded.
	 * @throws FileNotFoundException if the file is not in the 
	 * 								 specified location.
	 */
	public void loadData(String str)throws FileNotFoundException;
	
	/* This method will search through the ArrayList to find
	 * if any Book matches str.  If a Book matches that Book 
	 * is returned, else null is returned.
	 * 
	 * @param	str	the title of the Book that is being searched for.
	 * @return		the Book with the title str.
	 */
	public Book searchForBook(String str);
	
	/* This method will add a Book to the ArrayList.  The Book 
	 * will be added in alphabetical order.  This method will 
	 * return true if the Book is added successfully and false 
	 * otherwise
	 * 
	 * @param ISBN			The ISBN number of a book.
	 * @param title			The title of a book.
	 * @param author		The author of a book.
	 * @param publisher		The publisher of a book.
	 * @param publishedYear	The year a book is published.
	 * @return				true if the Book is added.
	 *  					false if the Book is not added
	*/
	public boolean addBook(String ISBN, String title, String author, String publisher, String publishedYear);
	
	/* This method will update a Book in the ArrayList.  It will 
	 * update any information except for the title.  This method
	 * will return true if the Book is updated successfully 
	 * and false otherwise.
	 * 
	 * @param ISBN			The ISBN number of a book.
	 * @param title			The title of a book.
	 * @param author		The author of a book.
	 * @param publisher		The publisher of a book.
	 * @param publishedYear	The year a book is published.
	 * @return				true if the Book is updated.
	 *  					false if the Book is not updated
	*/
	public boolean updateBook(String ISBN, String title, String author, String publisher, String publishedYear);
	
	/* This method will remove a Book with the title str from the 
	 * ArrayList. This method will return true if the Book is 
	 * removed, or it will return false if the Book is not removed.
	 * 
	 * @param  str	the title of the Book to be removed.
	 * @return		true if the Book is updated.
	 *  			false if the Book is not updated.
	*/
	public boolean removeBook(String str);
    
	/* This method will take in a publisher's name, str, and use it 
	 * to create a list of all Books that have str as their publisher.
	 * That list will then be returned.
	 * 
	 * @param	str	the name of the publisher of some group of Books.
	 * @return		the list of all Books with the str publisher.
	 */
	public ArrayList<Book> getBookByPublisher(String str);
	
	/* This method will be used to write the list of Books to a file.  
	 * The files name will be BookCatalog.txt.The method will return 
	 * true if the list is wrote correctly and false if it is not. The 
	 * file's text will follow this example:
	 * 
	 * 		ISBN
	 * 		Title
	 * 		Author
	 * 		Publisher
	 * 		Year of Book Publication
	 * 		Empty Line
	 * 
	 * @return				true if the Book is updated.
	 *  					false if the Book is not updated.
	 * @throws IOException 	if the file is not in the 
	 * 						specified location.
	*/
	public boolean save()throws IOException;
	
}
