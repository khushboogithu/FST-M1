package activities;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Giver array
		int[] numArr = {10, 77, 10, 54, -11, 10};
		
		//Total sum of 10's
		int sum=0;
		
		//iterate
		for(int num : numArr)
		{
			//Check the num is 10
			if(num == 10)
			{
				sum += num; // Add the 10's
			}
			if(sum>30)
			{
				break; //to prevent extra iterations
			}
			
		}
		
		//Check the sum value
		if(sum==30)
		{
			System.out.println("Sum value is:" +sum);
		}
		else
		{
			System.out.println("Sum value is not 30");
		}
		

	}

}
