package factory;
import factoryFramework.Factory;
import factoryFramework.Product;
import idcard.IDCardFactory;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("‚ä‚¤‚«");
		Product card2 = factory.create("‚Ù‚Þ‚ç");
		Product card3 = factory.create("‚è‚ñ‚²");
		
		card1.use();
		card2.use();
		card3.use();
	}

}
