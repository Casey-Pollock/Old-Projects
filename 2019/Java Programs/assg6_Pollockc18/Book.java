/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This class will be used to create and use a Book object.
 * Book will be used to store a book's ISBN, title, author, 
 * publisher, and its year of publication.  This class can 
 * also manipulate any given Book.  The Books can also be 
 * compared to one another.
*/

package assg6_Pollockc18;

public class Book implements Comparable<Book> {

	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private String publishedYear;
	
	/* This method creates a new Book object that consist of an
	 * ISBN number, a title, an author, a publisher, and a
	 * published year of the book.
	 * 
	 * @param ISBN			The ISBN number of a book.
	 * @param title			The title of a book.
	 * @param author		The author of a book.
	 * @param publisher		The publisher of a book.
	 * @param publishedYear	The year a book is published.
	*/
	public Book(String ISBN, String title, String author, String publisher, String publishedYear) {
		
		this.ISBN=ISBN;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.publishedYear=publishedYear;
		
	}
	
	/* This method will return a string that will be retrieved
	* from a Book.  This string will correspond to 
	* the ISBN number of that Book.
	*
	* @return  the ISBN number will be returned.
	* @see     Book
	*/
	public String getISBN() {
		
		return this.ISBN;
		
	}
	
	/* This method will return a string that will be retrieved
	* from a Book.  This string will correspond to 
	* the title of that Book.
	*
	* @return  the title will be returned.
	* @see     Book
	*/
	public String getTitle() {
		
		return this.title;
		
	}
	
	/* This method will return a string that will be retrieved
	* from a Book.  This string will correspond to 
	* the author of that Book.
	*
	* @return  the author will be returned.
	* @see     Book
	*/
	public String getAuthor() {
		
		return this.author;
		
	}
	
	/* This method will return a string that will be retrieved
	* from a Book.  This string will correspond to 
	* the publisher of that Book.
	*
	* @return  the publisher will be returned.
	* @see     Book
	*/
	public String getPublisher() {
		
		return this.publisher;
		
	}
	
	/* This method will return a string that will be retrieved
	* from a Book.  This string will correspond to 
	* the year that Book was published.
	*
	* @return  the publishing year will be returned returned.
	* @see     Book
	*/
	public String getPublishedYear() {
		
		return this.publishedYear;
		
	}
	
	/* This method will take a string that will become a part
	 * of a given Book.  This string will become 
	 * the new ISBN number.
	 *
	 * @param ISBN the new ISBN number for the Book.
	 * @see        Book
	*/
	public void setISBN(String ISBN) {
		
		this.ISBN=ISBN;
		
	}
	
	/* This method will take a string that will become a part
	 * of a given Book.  This string will become 
	 * the new author.
	 *
	 * @param author	the new author for the Book.
	 * @see    	    	Book
	*/
	public void setAuthor(String author) {
		
		this.author=author;
		
	}
	
	/* This method will take a string that will become a part
	 * of a given Book.  This string will become 
	 * the new publisher.
	 *
	 * @param publisher the new publisher for the Book.
	 * @see				Book
	*/
	public void setPublisher(String publisher) {
		
		this.publisher=publisher;
		
	}
	
	/* This method will take a string that will become a part
	 * of a given Book.  This string will become 
	 * the new year the Book was published.
	 *
	 * @param publishedYear the new year a Book was published.
	 * @see					Book
	*/
	public void setPublishedYear(String publishedYear) {
		
		this.publishedYear=publishedYear;
		
	}

	/* This method will return the string of a Book. 
	 * The string will consist of all provided 
	 * information about the Book.
	 *
	 * @return      the String of a Book's information.
	 * @override    toString()
	 * @see         Book
	*/
	public String toString() {
		
		return (this.ISBN+"\n"+this.title+"\n"+this.author+"\n"+this.publisher+"\n"+this.publishedYear+"\n");
		
	}

	/* This method will take an Object and test to see if it is
	 * equal to a specified Book.  This method will return 
	 * a boolean of true if the titles' of both Books are the same, 
	 * otherwise false is returned.
	 *
	 * @param obj  an object that may or may not be a Book.
	 * @return     true is returned if both Books' titles are the 
	 * 			   same.
	 * 			   false is returned otherwise.
	 * @override   equals().
	 * @see        Book
	*/
	public boolean equals(Object obj){
		
		if(obj==null){
			
			return false;
			
		}
		else if(obj instanceof Book){
			
			Book temp=(Book)obj;
			return this.title.equalsIgnoreCase(temp.title);
			
		}
		else{
			
			return false;
			
		}
	} 

	/* This method will take in a Book, o, and it will compare 
	 * it to a given Book.  This method will return an integer
	 * value base on the alphabetical order of the Books.  The
	 * given Book comes first in sequence if the integer returned
	 * is negative, the books are the same if zero is returned, and
	 * o comes first in sequence if the number is positive.
	 * 
	 * @param   o	the Book that will be compared to the given Book.
	 * @return		the order that the Book should be in. 
	 * @see			Book
	 * 
	 */
	@Override                       
	public int compareTo(Book o) {

		if(this.equals(o)) {
			
			return 0;
			
		}
		else {
			
			return this.title.compareToIgnoreCase(o.title);
				
			
		}
		
	}
	
}