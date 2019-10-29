import java.util.*;
import java.io.*;
/**
*
*@author KatieHenschell 
*@author MeganHeindl
*@date 10//27/2019
*@class CS335 Algoritms
*/
public class Prims {

	private ArrayList<SLList> list;

	//constructor
	public Prims(ArrayList<SLList> list) {
		this.list = list;
	}
	
	public void primsAlgorithm() {
		MinHeap<PrimsNode> queue = new MinHeap<PrimsNode>();//create a priority queue
		for(int i = 0; i < list.size(); i++) {//make and add nodes to the vertex list
			PrimsNode newNode = new PrimsNode(i);
			queue.insert(newNode);
		}
		int[] parent = new int[list.size()];
		PrimsNode head = queue.minimum();
		boolean[] found = new boolean[list.size()];
		head.setKey(0);
		while(!queue.isEmpty()) {
			PrimsNode node = queue.extractMin();
			found[node.getVertex()] = true;
			SLList slist = list.get(node.getVertex());//get the list of vertices the node can go to
			Node listNode = slist.getHead();
			while(listNode.getNext() != null) {
				int element = listNode.getElement();
				if(!found[element]){//if it is not already found
					
				}
				listNode = listNode.getNext();
			}
		}
	}
}
