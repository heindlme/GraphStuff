import java.util.*;
import java.io.*;
/**
*This class has the main in it and takes in the required file
*@author KatieHenschell 
*@author MeganHeindl
*@date 10//27/2019
*@class CS335 Algoritms 
*/
public class MakeGraph {
	
	private File file;
	private int size;
	
	public MakeGraph(File file){
		this.file = file;
	}
	
	public void readFile() throws FileNotFoundException{
		Scanner sc = new Scanner(file);
		size = 0;
		while(sc.hasNextLine()){
			sc.nextLine();
			size++;
		}
	}
	
	public ArrayList<SLList> makeList() throws FileNotFoundException{
		ArrayList<SLList> list = new ArrayList<SLList>(size);
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			Scanner line = new Scanner(sc.nextLine());
			int pos = 0;
			SLList tempList = new SLList();
			while(line.hasNextInt()){
				int temp = line.nextInt();
				if(temp != 0){
					tempList.add(pos,temp);
				}
				pos++;
			}
			list.add(tempList);
		}
		return list;
	}
	
}