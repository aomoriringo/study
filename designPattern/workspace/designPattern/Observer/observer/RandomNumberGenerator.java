package observer;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {

	// 乱数発生器
	private Random random = new Random();
	
	// 現在の数
	private int number;
	
	// 数を取得する
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
