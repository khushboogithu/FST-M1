package activities;

@FunctionalInterface
interface Addable {
    int add(int a, int b);
}

public class Activity12 implements Addable
{
	
	//Alternate way for basic interface calling
	public int add(int a, int b) {
		int c=a+b;
		System.out.println("Alternate way for basic interface calling result: " + c);
		return c; 
	}
	
    public static void main(String[] args) {

        // Lambda expression without return keyword.
    	// Lambda   Parameters   Operation
        Addable ad1 = (a, b) -> (a + b);
        System.out.println("The Result1 is: " + ad1.add(10, 20));

        // Lambda expression with return keyword.
        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println("The Result2 is: " + ad2.add(100, 200));       
               
        }
}