package proxy;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		
		System.out.println("–¼‘O‚ÍŒ»İ" + p.getPrinterName() + "‚Å‚·");
		p.setPrinterName("Bob");
		System.out.println("–¼‘O‚ÍŒ»İ" + p.getPrinterName() + "‚Å‚·");
		p.print("Hello, world");
	}

}
