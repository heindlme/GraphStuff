import java.util.*;
import java.lang.*;
/**
 * Name: Megan Heindl
 * Project: SLList.java
 * Description: Implements a single-linked list
 */
public class SLList implements List{
	private Node head;
	private int size = 0;//the number of elements in list

	/**Constructors*/
	public SLList(int item, int weight) {
		head = new Node(item, weight);
		size++;
	}
	
	public SLList() {
		head = null;
		size = 0;
	}
	
	/** Remove all contents from the list, so it is once again
      empty. */
	public void clear() {
		head = null;
		size = 0;
	}	
  
	/** Insert an element at the given location. 
	 * allows you to insert after the tail
     * @param item The element to be inserted. 
	 */
    public void insert(int index, int item, int weight){
		if(index < 0|| index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if(index == 0) {//new head
			addFirst(item, weight);//helper method
		} else {
			Node node = getNode(index-1);//using a helper
			addAfter(node, item, weight);
		}
		
	}
	
	/**
	 * Creates a new head
	 * @param item the item to go into the new head
	 */
	private void addFirst(int item, int weight) {
		head = new Node(item, weight, head);
		size++;
	}
	
	/**
	 * Creates a new node after another node in the list
	 * @param node that is before the one that is being added
	 * @param item the item to go into the new node
	 */
    private void addAfter(Node node, int item, int weight) {
		node.setNext(new Node(item, weight, node.getNext()));
		size++;
	}
	
	/**
	 * helper returns the node at a given index
	 * @param index the index of the node to get
	 * @return the item in the node at the index
	 */
	private Node getNode(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node node = head;
		for(int i = 0; i < index; i++) {
			node = node.getNext();
		}
		return node;
	}
	
	/** Append an element at the end of the list.
	 *  @param item The element to be appended.
	 */
	public void add(int item, int weight){
		insert(size, item, weight);
		
	}
  
  
	/** 
	 * Remove the  element at the given location.
	 */
	public void remove(int index){
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node temp = getNode(index);
		if(index == 0){
			head = temp.getNext();
		} else if(temp.getNext()!=null) {
			Node previous = getNode(index-1);
			previous.setNext(temp.getNext());
		} else {
			Node previous = getNode(index-1);
			previous.setNext(null);
		}
		size--;
	}
  
  
  
	/** 
	 * Get the element in the position to one step left. 
	 * @return element in the node to the left of the node at the index, 
	 * null if at the head. 
	 */  
	public int prev(int index){
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if (index ==0) {
		return -1;
		}
		return getValue(index-1);
	}
  
  
	/** Get the element in the position one step right. 
	 * @return the element in the node to the right of 
	 * the node at the index, null if at the end. 
	 */
	public int next(int index){
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if(index == size -1) {
			return -1;
		}
		return getValue(index+1);
	}
  
  
	/** @return The number of elements in the list. */
	public int length(){		
		return size;
	}
    
    
	/** Turn the contents of the Nodes to a string in order from head to end.
	 * @return The String representation of the 
	 * elements in the list from head to end. 
	 */
	public String toString(){
		Node node = head;
		String result = "";
		while(node != null) {
			result = result + node.toString();
			if(node.getNext() != null) {
				result = result + " ==> ";
			}
			node = node.getNext();
		}
		return result;
	}
  
	/** Reverse the content of the list.
	 * if list is A => B => C it becomes C => B => A
	 */
	public void reverse(){
		Node node = head;
		if(node == null || node.getNext()== null) {
			return;
		}
		Node prev = node.getNext();
		Node curr = prev.getNext();
		prev.setNext(node);
		node.setNext(null);
		while(curr != null) {
			Node next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
		}
		head = prev;
	}
  
   
	/** @return The  element at given position. */
	public int getValue(int index){
		Node node = getNode(index);
		return node.getElement();
	}
   
	/**inserts the given list after the given index
	 * @param list the list to be inserted
	 * @param index the location for insertion (after the index)
	 */
	public void insertList (SLList list, int index){
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if(list.head != null) {
			Node tail = list.getLast();
			Node head = list.head;
			Node before = getNode(index);
			if(before.getNext()!=null) {
				Node after = getNode(index+1);
				tail.setNext(after);
			} 
			before.setNext(head);
		}
		size += list.length();
	}

	/**
	 * @return the head of the list
	 */
	public Node getHead(){
		return head;
	}
	
	/**
	 * @return the tail of the list
	 */
	public Node getLast(){
		return getNode(size-1);
	}

}