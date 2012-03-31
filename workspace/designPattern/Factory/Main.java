import framework.Factory;
import framework.Product;
import idcard.IDCardFactory;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("ゆうき");
		Product card2 = factory.create("ほむら");
		Product card3 = factory.create("りんご");
		
		card1.use();
		card2.use();
		card3.use();
	}

}
