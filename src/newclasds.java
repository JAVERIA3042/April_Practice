import java.util.ArrayList;
import java.util.Iterator;

public class newclasds {

	public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>(); 
        
        list.add("I"); 
        list.add("Q"); 
        list.add("r"); 
        list.add("A"); 
        list.add("J"); 
  
        // Iterator to traverse the list 
        Iterator iterator = list.iterator(); 
  
        System.out.println("List elements : "); 
  
        while (iterator.hasNext()) 
            System.out.print(iterator.next() + " "); 
  
        System.out.println(); 
        
        
        
   
  
    } 

	}

