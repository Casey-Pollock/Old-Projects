/* @author Casey Pollock
 * Assignment 9
 * CSCI 2540
 *
 * This class will be be used to create and manipulate a PhoneBook.
 * This PhoneBook will be automatically loaded and saved with information 
 * about different Persons and their provided information. The Phone
 * Book can be searched for a specific individual.  New PErsons can
 * be added to the PhoneBook or Persons can be removed from the 
 * PhoneBook.  The information on a Person may also be altered.
*/

package assg9_pollockc18;

import java.io.*;
import java.util.Scanner;

public class PhoneBook {
	
	private Node root;
	
	/**
	 * Initializes a PhoneBook with a tree of Nodes.
	 * @param root THe base of the tree of Nodes.
	 */
	public PhoneBook(Node root) {
		
		this.root=root;
		
	}
	
	/**
	 * Initializes a PhoneBook with a tree of Nodes
	 */
	public PhoneBook() {
		
		this.root=null;
		
	}
	
	/**
	 *  Adds a Node to the PhoneBook based on the
	 *  name of the Person associated with the Node.
	 *  @param p The Person who is assigned to a Node.
	 */
	public void add(Person p) {
		
		Node add=new Node(p), leaf=this.root;
		int compare=0; boolean escape=true;
		
		if(leaf==null)
			this.root=add;
		else {
			
			
			while(escape) {
				
				compare=leaf.compareTo(add);
				if(compare<0) {
					
					if(leaf.getLeft()==null) 
						escape=false;
					else 
						leaf=leaf.getLeft();
						
				}
				else if(compare>0){
					
					if(leaf.getRight()==null)
						escape=false;
					else 
						leaf=leaf.getRight();
					
				}
				else
					escape=false;
				
			}
			
		}
		if(compare<0)
			leaf.setLeft(add);
		if(compare>0)
			leaf.setRight(add);
		
	}
	
	/** 
	 * Gets the name of a Person and locates them in the PhoneBook
	 * @param  name The name of the Person.
	 * @return The Node containing the person
	 */
	public Node search(String name) {
		
		return this.root.find(name);
		
	}
	
	/** 
	 * Changes the phone number of a Person by finding their name.
	 * @param name The name of the Person.
	 * @param mun The new phone number of the Person.
	 */
	public void update(String name, long num) {
		
		this.root.update(name, num);
		
	}
	
	/**
	 * Removes the Node with the same name as the provided name.
	 * @param name The name of a Person.
	 */
	public void delete(String name) {
		
		Node replace, temp, delete, parent;
		
		delete=this.root.find(name);
		
		if(delete==null) {
			
			System.out.println("Name not found.");
			return;
			
		}
		temp=delete.getRight();
		replace=delete.getLeft();
		if(temp!=null && replace!=null)
			replace.moveToEOC(temp);
		else if(temp!=null && replace==null)
			replace=temp;
		if(this.root.compareTo(delete)!=0) {
			parent=this.root.findParent(delete);
		
			int compare=parent.compareTo(delete);
		
			if(compare<0)
				if(replace==null)
					parent.setLeft(null);
				else
					parent.setLeft(replace);
			if(compare>0)
				if(replace==null)
					parent.setRight(null);
				else
					parent.setRight(replace);
			
		}
		else {
			
			this.root=replace;
			
		}
		
	}
	
	/**
	 * Loads Nodes from an input file. The file will be in the 
	 * format of a name a tab and a phone number on 
	 * a line.  Each line will contain a person.  
	 * @param input the name of the input file.
	 * @throws FileNotFoundException
	 */
	public void load(String input) throws FileNotFoundException{
		
		Scanner file=new Scanner(new File(input));
		Person temp; String name; long num;
		
		while(file.hasNext()) {
			
			name=(file.next()+" "+file.next());
			num=file.nextLong();
			temp=new Person(name, num);
			
			this.add(temp);
		
		}
		file.close();
		
	}
	
	/**
	 * Saves Nodes in an output file. The file will be in the 
	 * format of a name a tab and a phone number on 
	 * a line.  Each line will contain a person.  
	 * @param output The name of the output file.
	 * @throws IOException
	 */
	public void save(String file) throws IOException{
		
		FileOutputStream outputFile = new FileOutputStream(file);
			
		outputFile.write(this.toString().getBytes());
		
		outputFile.close();

		
	}
	
	/**
	 * Overridden toString method
	 * @return The full list of Nodes within the tree.
	 */
	public String toString() {
		
		if(this.root.isLeaf())
			return this.root.toString();
		else if(this.root.getLeft()!=null && this.root.getRight()!=null)
			return (new PhoneBook(this.root.getLeft()).toString()+this.root.toString()+new PhoneBook(this.root.getRight()).toString());
		else if(this.root.getLeft()!=null)
			return (new PhoneBook(this.root.getLeft()).toString()+this.root.toString());
		else 
			return (new PhoneBook(this.root.getRight()).toString()+this.root.toString());
		
	}
	
}
