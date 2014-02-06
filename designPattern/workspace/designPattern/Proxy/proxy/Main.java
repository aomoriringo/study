package proxy;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Printable p = new PrinterProxy("Alice");
		
		System.out.println("���O�͌���" + p.getPrinterName() + "�ł�");
		p.setPrinterName("Bob");
		System.out.println("���O�͌���" + p.getPrinterName() + "�ł�");
		p.print("Hello, world");
	}

}
