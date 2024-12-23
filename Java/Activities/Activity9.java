package activities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity9 {
	
    public static void main(String[] args) {
    	
        //create an Array list
        List<String> myList = new ArrayList<>();
        
        //Adding 5 names to the list
        myList.add("Apple");
        myList.add("Mango");
        myList.add("Orange");
        
        //Adding object at specific index
        myList.add(1, "Papaya");
        myList.add(3, "Grapes");    
        myList.add(4, "Melon");
        
        System.out.println("Print All the elements:");
        for(String name:myList){
            System.out.println(name);
        }
        
        Iterator<String> iter = myList.iterator();{        	
        	System.out.println("Iterator result: " + iter.hasNext());
        }
        
        //Print the 3rd element
        System.out.println("The Third element in the list is: " + myList.get(2));
        
        //Search for a specific name
        System.out.println("Is Ksbu in the list: " + myList.contains("Ksbu"));
        
        System.out.println("Size of ArrayList: " + myList.size());
        
        //Removing the element using value & index, value is not applicable for INT
        myList.remove("Papaya");
        myList.remove(4);
        
        System.out.println("New Size of ArrayList: " + myList.size());
        
        //Printing using while loop
        
        int index = 0;

        System.out.println("Printing all the elements using while loop:");
        
        while (index < myList.size()) {
            System.out.println(myList.get(index));
            index++;
    }
  }
}