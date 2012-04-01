package bridge;

import bridgeFunction.CountDisplay;
import bridgeFunction.Display;
import bridgeImplementation.StringDisplayImpl;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display d1 = new Display(new StringDisplayImpl("Hello, Japan."));
		Display d2 = new CountDisplay(new StringDisplayImpl("Hello, world."));
		
		CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe."));
		
		d1.display();
		d2.display();
		d3.display();
		d3.multiDisplay(5);
	}

}
