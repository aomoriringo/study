package singleton;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start.");
		
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1 == obj2)
		{
			System.out.println("obj1��obj2�͓����C���X�^���X�ł�");
		}
		else
		{
			System.out.println("obj1��obj2�͓����C���X�^���X�ł͂���܂���");
		}
		System.out.println("End.");
	}

}
