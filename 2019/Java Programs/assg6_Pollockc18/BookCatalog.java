/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This class will be used to create and use a Book catalog list.
 * This list will be loaded from a text file and saved to a file.  
 * The list can have a Book updated, added, and removed.  The list 
 * can be searched to find a specified Book or to find all the Books 
 * by a specified publisher.
*/


package assg6_Pollockc18;

import java.io.*;
import java.util.*;

public class BookCatalog implements BookCatalogInterface {
	
	private ArrayList<Book> list= new ArrayList<Book>();;

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
	public void loadData(String str)throws FileNotFoundException {
		
		Scanner inputFile=new Scanner(new File(str));
		String title, author, publisher, ISBN, publishYear;
	    
	    while(inputFile.hasNextLine()){
	    
	      ISBN=inputFile.nextLine();
	      title=inputFile.nextLine();
	      author=inputFile.nextLine();
	      publisher=inputFile.nextLine();
	      publishYear=inputFile.nextLine();
	      if(inputFile.hasNextLine())
	    	  inputFile.nextLine();
	      
	      list.add(new Book(ISBN, title, author, publisher, publishYear));

	    }
	    inputFile.close();
	}
	
	/* This method will search through the ArrayList to find
	 * if any Book matches str.  If a Book matches that Book 
	 * is returned, else null is returned.
	 * 
	 * @param	str	the title of the Book that is being searched for.
	 * @return		the Book with the title str.
	 */
	public Book searchForBook(String str) {
		
		Iterator<Book> iter = list.iterator();
		
		while(iter.hasNext()) {
			
			Book temp=iter.next();
			if(str.equalsIgnoreCase(temp.getTitle()))
				return temp;
			
		}
		return null;
		
	}
	
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
	public boolean addBook(String ISBN, String title, String author, String publisher, String publishedYear){
		
		Book newBook=new Book(ISBN, title, author, publisher, publishedYear);
		Iterator<Book> iter = list.iterator();
		int order, counter=-1;
		
		while(iter.hasNext()) {
			
			Book temp=iter.next();
			order=newBook.compareTo(temp);
			counter++;
			
			if(order==0) {
				
				return false;
				
			}
			if(order<0) {
				
				list.add(counter, newBook);
				return true;
				
			}
			
		}
		return false;
		
	}
	
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
	public boolean updateBook(String ISBN, String title, String author, String publisher, String publishedYear){
		
		Iterator<Book> iter = list.iterator();
		Book revised= new Book(ISBN, title, author, publisher, publishedYear);
		int count=0;
		
		while(iter.hasNext()) {
			
			Book temp=iter.next();
			if(title.equalsIgnoreCase(temp.getTitle())) {
				
				list.set(count, revised);
				return true;
				
			}
			count++;	
				
			
		}
		return false;
		
	}
	
	/* This method will remove a Book with the title str from the 
	 * ArrayList. This method will return true if the Book is 
	 * removed, or it will return false if the Book is not removed.
	 * 
	 * @param  str	the title of the Book to be removed.
	 * @return		true if the Book is updated.
	 *  			false if the Book is not updated.
	*/
	public boolean removeBook(String str) {
		
		Iterator<Book> iter = list.iterator();
		int count=0;
		
		while(iter.hasNext()) {
			
			Book temp=iter.next();
			if(str.equalsIgnoreCase(temp.getTitle())) {
				
				list.remove(count);
				return true;
				
			}
			count++;
				
			
		}
		return false;
	}
	
	/* This method will take in a publisher's name, str, and use it 
	 * to create a list of all Books that have str as their publisher.
	 * That list will then be returned.
	 * 
	 * @param	str	the name of the publisher of some group of Books.
	 * @return		the list of all Books with the str publisher.
	 */
	public ArrayList<Book> getBookByPublisher(String str){
		
		Iterator<Book> iter = list.iterator();
		ArrayList<Book> requestedList= new ArrayList<Book>();
		
		while(iter.hasNext()) {
			
			Book temp=iter.next();
			if(str.equalsIgnoreCase(temp.getPublisher()))
				requestedList.add(temp);
			
		}
		return requestedList;
		
	}
	
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
	public boolean save()throws IOException{
		
		FileOutputStream outputFile = new FileOutputStream("BookCatalog.txt");
		
		Iterator<Book> iter= list.iterator();
		
		while(iter.hasNext()) {
			
			outputFile.write((iter.next().toString()+"\n").getBytes());
			
		}
		
		outputFile.close();
		return true;
	}
	
}
