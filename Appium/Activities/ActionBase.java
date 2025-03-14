package activities;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

//import java.awt.Point;
import java.util.Arrays;

import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;

import io.appium.java_client.AppiumDriver;

public class ActionBase {
	
	//create the pointer
	  static final PointerInput pointer = new  PointerInput(Kind.TOUCH, "finger");
	  
	//Create the action function
  @Test
  public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
	  
	  //create a sequence of actions
	  Sequence swipe = new Sequence(pointer, 1).
			  addAction(pointer.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY())).
			  addAction(pointer.createPointerDown(LEFT.asArg())).
			  addAction(pointer.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY())).
			  addAction(pointer.createPointerUp(LEFT.asArg()));
	  
	  //Perform the actions
	  driver.perform(Arrays.asList(swipe));
	  
	  
	  
	  
  }
}
