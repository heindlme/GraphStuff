import java.util.*;
import java.io.*;
/**
*This class has the main in it and takes in the required file
*@author KatieHenschell 
*@author MeganHeindl
*@date 10//27/2019
*@class CS335 Algoritms
*/
public class GraphStuff {
	public static void main(String[] args) throws FileNotFoundException {
		if(args.length == 0){ //makes sure user passes in a file
			System.out.println("No file was passed in. Proper usage is \"java program filename\".");
			System.exit(0);
		} //sends the file to the file reader
		File file = new File(args[0]);  
		MakeGraph graph = new MakeGraph(file);//makes a graph with the file
		graph.readFile();//reads the file and counts the lines
		ArrayList<SLList> list = graph.makeList();//makes an adjacency list from the file
		System.out.println(list.toString());
		
	}
}