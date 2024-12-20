package activities;

public class Activity1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car carObj = new Car("Red", "Manual", 2020);
		System.out.println();
		
		carObj.displayCharacteristics();
		carObj.accelerate();
		carObj.brake();
		
	}

}
