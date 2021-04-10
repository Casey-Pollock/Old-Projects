/* @author Casey Pollock
 * Assignment 9
 * CSCI 2540
 *
 * This class will be be used to create and manipulate a tree of Nodes.
 * These Nodes can be tested to check if they are at the end of a tree.
 * The different branches an be retrieved or moved.  Specific Nodes or 
 * the parent of some specific Nod can be located and returned.  The 
 * Nodes may also be compared.
*/

package assg9_pollockc18;

public class Node {
	
	private <T> item;
	private Node left;
	private Node right;
	
	/**
	 * Initializes a Node with a person and two adjacent Nodes.
	 * @param person The person affiliated with this Node.
	 */
	public Node<T>(<T> item) {
		
		this.item=item;
		this.left=null;
		this.right=null;
		
	}
	
	/** 
	 * Gets the Person of a Node.
	 * @return The Person.
	 */
	public <T> getItem() {
		
		return this.item;
		
	}
	
	/** 
	 * Gets the Node to the right of this Node.
	 * @return The Node on the right.
	 */
	public Node getRight() {
		
		return this.right;
		
	}
	
	/** 
	 * Changes the current Node right to point to right.
	 * @param right THe new right Node.
	 */
	public void setRight(Node right) {
		
		this.right=right;
		
	}
	
	/** 
	 * Gets the Node to the left of this Node.
	 * @return The Event type
	 */
	public Node getLeft() {
		
		return this.left;
		
	}
	
	/** 
	 * Changes the current Node left to point to left.
	 * @param left THe new left Node.
	 */
	public void setLeft(Node left) {
		
		this.left=left;
		
	}
	
	/**
	 *  Checks for if there is a Node following the current Node.
	 * @return True if the Node has two null pointers.
	 */
	public boolean isLeaf() {
		
		return (this.right==null && this.left==null);
		
	}
	
	/** 
	 * Changes the currents Nodes position to the end of the next closest
	 * left chain of Nodes.
	 * @param move the Node that will be moved.
	 */
	public void moveToEOC(Node move) {
		
		Node temp=this;
		
		while(temp.right!=null)
			temp=this.right;
		temp.right=move;
		
	}
	
	/** 
	 * Gets the name of a Person and locates it in a list of Nodes.
	 * @param name The name of the Person.
	 * @return The Node with the shared name.
	 */
	public Node find(String name) {
		
		int compare=this.item.compareTo(name);
		
		if(compare>0) {
			
			if(this.right!=null)
				return this.right.find(name);
			else
				return null;
			
		}
		else if (compare<0){
			
			if(this.left!=null)
				return this.left.find(name);
			else
				return null;
			
		}
		else
			return this;
		
	}
	
	/** 
	 * Gets a Node and locates the Node preceding it.
	 * @param child A Node that comes after the returned Node.
	 * @return The Node that comes before the child.
	 */
	public Node findParent(Node child) {

		int compare= this.compareTo(child);
		Node temp;
		
		if(compare<0) {
			
			temp=this.left;
			if(temp.equals(child))
				return this;
			else
				return temp.findParent(child);
			
		}
		else {
			
			temp=this.right;
			if(temp.equals(child))
				return this;
			else
				return temp.findParent(child);
			
		}
		
	}

}
