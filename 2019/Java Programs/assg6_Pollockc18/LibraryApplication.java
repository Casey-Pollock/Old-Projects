/* @author Casey Pollock
 *         Assignment 3
 *         CSCI 2540
 *
 * This class will be be used to create and manipulate a list of Books.
 * This list can have a new Book entered, a Book removed, and a Book 
 * updated. The list can be searched to find a specific Book or all 
 * Books with a specified publisher.  The list will later be saved and 
 * wrote into a text file.
*/


package assg6_Pollockc18;

import java.io.*;
import java.util.*;

public class LibraryApplication{

	public static void main(String[] args) {
		
		final String fileName="BookCatalog.txt";
		Scanner kbd = new Scanner(System.in);
		int choice;
		String title, author, publisher, ISBN, publishedYear;
		boolean contin=true, update=false;
		BookCatalog catalog = new BookCatalog();
		ArrayList<Book> list;
		Iterator<Book> iter;
		
		try {
			
			catalog.loadData(fileName);
			do{
			
				System.out.print("1.\tSearch for a book.\n2\tAdd a new book.\n3.\tUpdate a book.\n"+ "4.\tRemove a book.\n"
								+ "5.\tSearch for a book a publisher.\n6.\tSave data\n7.\tExit.\nPlease enter your choice(1-7):");
				choice=kbd.nextInt();
				kbd.nextLine();
				switch(choice) {
			
				case 1:
					System.out.print("Please enter a book's title:");
					title=kbd.nextLine();
					if(catalog.searchForBook(title)==null)
						System.out.println("Sorry "+title+" is not found.");
					else
						System.out.print(catalog.searchForBook(title)+"\n");
					break;
				case 2:
					System.out.print("Please enter the book's title:");
					title=kbd.nextLine();
					System.out.print("Please enter the book's ISBN:");
					ISBN=kbd.nextLine();
					System.out.print("Please enter the book's author:");
					author=kbd.nextLine();
					System.out.print("Please enter the book's publisher:");
					publisher=kbd.nextLine();
					System.out.print("Please enter the book's published year:");
					publishedYear=kbd.nextLine();
					if(catalog.addBook(ISBN,title, author, publisher, publishedYear))
						System.out.println("Book added.");
					else
						System.out.println("Unablde to add book.");
					update=true;
					break;
				case 3:
					System.out.print("Please enter the book's title:");
					title=kbd.nextLine();
					Book temp=catalog.searchForBook(title);
					do {
						
						System.out.println("Updating "+ title);
						System.out.println("1.\tUpdate the ISBN.\n2.\tUpdate the author\n3.\tUpdate the publisher.\n"
											+ "4.\tUpdate the publised year\n5.\tExit\nPlease enter your choice(1-5):");
						choice=kbd.nextInt();
						kbd.nextLine();
						switch(choice) {
						
						case 1:
							System.out.print("Please enter the book's ISBN:");
							ISBN=kbd.nextLine();
							author=temp.getAuthor();
							publisher=temp.getPublisher();
							publishedYear=temp.getPublishedYear();
							if(catalog.updateBook(ISBN, title, author, publisher, publishedYear))
								System.out.println("Book updated.");
							else
								System.out.println("Unable to update book.");
							update=true;
							break;
						case 2:
							System.out.print("Please enter the book's author:");
							author=kbd.nextLine();
							ISBN=temp.getISBN();
							publisher=temp.getPublisher();
							publishedYear=temp.getPublishedYear();
							if(catalog.updateBook(ISBN, title, author, publisher, publishedYear))
								System.out.println("Book updated.");
							else
								System.out.println("Unable to update book.");
							update=true;
							break;
						case 3:
							System.out.print("Please enter the book's publisher:");
							publisher=kbd.nextLine();
							ISBN=temp.getISBN();
							author=temp.getAuthor();
							publishedYear=temp.getPublishedYear();
							if(catalog.updateBook(ISBN, title, author, publisher, publishedYear))
								System.out.println("Book updated.");
							else
								System.out.println("Unable to update book.");
							update=true;
							break;
						case 4:
							System.out.print("Please enter the book's published year:");
							publishedYear=kbd.nextLine();
							ISBN=temp.getISBN();
							author=temp.getAuthor();
							publisher=temp.getPublisher();
							if(catalog.updateBook(ISBN, title, author, publisher, publishedYear))
								System.out.println("Book updated.");
							else
								System.out.println("Unable to update book.");
							update=true;
							break;
						case 5:
							contin=false;
							break;
						default:
							System.out.println("Error: Please enter a valid value.");
							break;
						
						}
						
					} while(contin);
					contin=true;
					break;
				case 4:
					System.out.print("Please enter the book's title:");
					title=kbd.nextLine();
					if(catalog.removeBook(title))
					System.out.println("Book removed.");
				else
					System.out.println("Unable to remove book.");
					update=true;
					break;
				case 5:
					System.out.print("Please enter the book's publisher:");
					publisher=kbd.nextLine();
					list=catalog.getBookByPublisher(publisher);
					iter=list.iterator();
					while(iter.hasNext()) {
						
						System.out.print(iter.next()+"\n");
						
					}
					break;
				case 6:
					if(update) {
						
						if(catalog.save())
							System.out.println("Book catalog saved.");
						else
							System.out.println("Unable to save the book catalog.");
						update=false;
						
					}
					break;
				case 7:
					if(update) {
						
						if(catalog.save())
							System.out.println("Book catalog saved.");
						else
							System.out.println("Unable to save the book catalog.");
						update=false;
						
					}
					contin=false;
					break;
				default:
					System.out.println("Error: Please enter a valid value.");
					break;
			
				}
			} while(contin);
			kbd.close();
			
		}
		catch(IOException e) {
			
			System.out.println("Error: File not Found.");
			
		}

	}


}
