
/**
 * Node class for Linked List
 */
public class PrimsNode implements Comparable<PrimsNode>{
	private int vertex;
	private int key;
	
	/** Constructor
	* @param item the element to be stored in Node
	* @param nextVal the next Node that this is pointing to
	*/
	public PrimsNode(int vertex) { 
		this.vertex = vertex;
		key = Integer.MAX_VALUE;
	}

	//other constructors
	public PrimsNode(){
		vertex = -1;
		key = Integer.MAX_VALUE;
	}
		
	public int getVertex(){
		return vertex;
	}
	
	public void setVertex(int vertex){
		this.vertex = vertex;
	}
	
	/** 
	 * returns the element in the Node
	 *@return element in the Node
	 */  
	public int getKey() { 
		return key; 
	}  
	
	/**
	 * sets the element stored in Node to the element given
	 *@param item the element to be stored in Node.
	 */
	public void setKey(int key) {
		this.key = key; 
	}
	
	public String toString(){
		return "vertex: " + vertex + " key: " + key;
	}
	
	/**
	 * Override compareTo method
	 */
	public int compareTo(PrimsNode node) {
		if(node.key < key) {
			return -1;
		} else if (node.key == key) {
			return 0;
		}
		return 1;
	}
}
