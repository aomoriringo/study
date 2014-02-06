package observer;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {

	// —””­¶Ší
	private Random random = new Random();
	
	// Œ»İ‚Ì”
	private int number;
	
	// ”‚ğæ“¾‚·‚é
	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public void execute() {
		for(int i=0 ; i<20 ; i++){
			number = random.nextInt(50);
			notifyObservers();
		}
	}

}
