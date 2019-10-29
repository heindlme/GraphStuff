import java.util.*;
public class MinHeap<E extends Comparable <E>>{
	
	private ArrayList<E> array;
    private int numOfItems;      
  	
	/**Constructor
	*/
	public MinHeap(){	
		array = new ArrayList<E>();
		numOfItems = 0;	  
	}
  	 /** returns true of the heap is empty
  	 */
  	public boolean isEmpty(){
  		return numOfItems == 0;
  	}
   	/**
	 * Swap two locations i and j in ArrayList a.
	 * @param a the arrayList
	 * @param i first position
	 * @param j second position
	 */
	private static <E> void swap(ArrayList<E> a, int i, int j){		
		E temp = a.get(i);
		a.set(i, a.get(j));
		a.set(j, temp);
	}

	/**
	 * Return the index of the left child of node i.
	 * @param i index of the parent node
	 * @return index of the left child of node i
	 */
	private static int leftChild(int i) {		
		return 2 * i + 1;
	}


	/**
	 * Return the index of the right child of node i.
	 * @param i index of parent
	 * @return the index of the right child of node i
	 */
	private static int rightChild(int i) {	
		return 2 * i +2;
	}

	/**
	 * Return the index of the parent of node i
	 * (Parent of root will be -1)
	 * @param i index of the child
	 * @return index of the parent of node i
	 */
	private static int parent(int i) {		
		return (i-1)/2;
	}

	/**
	 * Insert an element into the heap.  
	 * Keep in heap order
	 * @param element the element to insert
	 */
	public void insert(E element) {
		array.add(element);//last free spot in our array
		int loc = numOfItems;//our current locations
		//determine if we need to swap - if parent is not larger and not root
		while(loc > 0 && array.get(loc).compareTo(array.get(parent(loc))) < 0){
			swap(array, loc, parent(loc));
			loc = parent(loc);
		}
		numOfItems++;
	}

	
    	/**
	 * Return the element with the minimum key, and remove it from the heap.
	 * @return the element with the minimum key, or null if heap empty.
	 */	
	public E extractMin() {
		if(isEmpty()) {
			return null;
		} else {
			//get root
			E minVal = array.get(0);
			//move the last item to the root
			array.set(0, array.get(array.size()-1));
			//remove the last item
			array.remove(array.size()-1);
			minHeapify(array, 0);//sift down the new root
			//decrement my ocunt
			numOfItems--;
			return minVal;
		}
	}
	
	/**
	 * Restore the min-heap property.  When this method is called, the min-heap
	 * property holds everywhere, except possibly at node i and its children.
	 * When this method returns, the min-heap property holds everywhere.
	 * @param a the list to sort
	 * @param i the position of the possibly bad spot in the heap
	 */
	private static <E extends Comparable<E>> void minHeapify(ArrayList<E> a, int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int smallest;
		//among node i and left and right - find the smallest element
		//is there a left child nad if so, does the left child have an element
		//smaller than node i?
		if(left < a.size()-1 && a.get(left).compareTo(a.get(i)) < 0) {
			smallest = left;
		} else {
			smallest = i;
		}
		//is there a right child and if so, does the right child have an element
		//smaller than node i or the left child/
		if(right < a.size()-1 && a.get(right).compareTo(a.get(smallest)) < 0) {
			smallest = right;
		}
		//if node i holds an element that is smaller than both the left and right children,
		// then the min-heap property already held, and we don't need to do anything.
		// Otherwise, we need to swap node i with the smallest and then recurse down the heap
		// from the smaller child.
		if(smallest != i) {
			swap(a, i, smallest);
			minHeapify(a, smallest);
		}
	}
	
	/**
	 * Return the element with the minimum key, without removing it from the heap.
	 * @return the element with the minimum key, or null if heap empty.
	 */
	public E minimum() {
		if(isEmpty()) {
			return null;
		}
		return array.get(0);
	}
	
}
