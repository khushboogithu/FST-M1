package activities;

import java.util.*;

public class Activity13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numArr = new ArrayList<Integer>();
        Random indexGen = new Random();
        
        //scanning will be stop on pressing non-Integer number        
        System.out.print("Enter integers please ");
        System.out.println("(EOF or non-integer to terminate): ");

        while(scan.hasNextInt()) {
        	numArr.add(scan.nextInt());
        }

        Integer nums[] = numArr.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        System.out.println("Index value generated: " + index);
        System.out.println("Value in arary at generated index: " + nums[index]);
        
        //Alternate way to print the index value
        
        System.out.println("Alternate way: Value in arary at generated index: " + numArr.get(index));

        scan.close();
    }
}