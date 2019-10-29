
/**
 * Node class for Linked List
 */
public class Node implements Comparable<Node>{
	private int element;        // Value for this node
	private int weight;
	private Node next;     // reference to next node in list
	
	/** Constructor
	* @param item the element to be stored in Node
	* @param nextVal the next Node that this is pointing to
	*/
	public Node(int item, int weight, Node nextval) { 
		element = item;  
		this.weight = weight;
		next = nextval; 
	}
	/** Constructor
	* @param item the element to be stored in Node
	*/
	public Node(int item, int weight){
		element = item;
		this.weight	= weight;
		next = null;
	}
	//other constructors
	public Node(){
		element = 0;
		weight = 0;
		next = null;
	}
	public Node(Node nextval) { 
		next = nextval; 
	}
 
	/**
	 *@return the Node that is next to this
	 */
	public Node getNext() { 
		return next; 
	}  

	/**
	 * Sets this next to the given Node
	 * @param nextNal the Node that is to be set to this Node's next
	 */
	public void setNext(Node nextval){
		next = nextval; 
	}     
	
	public int getWeight(){
		return weight;
	}
	
	public void setWeight(){
		this.weight = weight;
	}
	
	/** 
	 * returns the element in the Node
	 *@return element in the Node
	 */  
	public int getElement() { 
		return element; 
	}  
	
	/**
	 * sets the element stored in Node to the element given
	 *@param item the element to be stored in Node.
	 */
	public void setElement(int item) {
		element = item; 
	}
	public String toString(){
		return "element: " + element + " weight: " + weight;
	}
	
	/**
	 * Override compareTo method
	 */
	public int compareTo(Node node) {
		if(node.weight < weight) {
			return -1;
		} else if (node.weight == weight) {
			return 0;
		}
		return 1;
	}
}
