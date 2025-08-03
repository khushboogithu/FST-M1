package activities;

public class Activity1 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Object creation of Car class
		Car honda = new Car("Black", "Automatic", 2020);
		
		honda.displayCharacteristics(); //Print the car details
		honda.accelerate(); //Move the car
		honda.brake(); //stop the car

	}

}
